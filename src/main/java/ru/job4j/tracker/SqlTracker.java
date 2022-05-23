package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    private Statement statement;

    public void init() throws SQLException {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        statement = createStatement();
        createTable();
    }

    private Statement createStatement() throws SQLException {
        return cn.createStatement();
    }

    private void createTable() throws SQLException {
        String sql = "create table if not exists items(id serial primary key, name text, create_time timestamp)";
        statement.executeUpdate(sql);
    }

    @Override
    public Item add(Item item) throws SQLException {
        String sql = String.format("insert into items(name, create_time) values ('%s', '%s')", item.getName(), Timestamp.valueOf(item.getDataTime()));
        statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getInt(1));
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        String sql = String.format("update items set name = '%s', create_time = '%s' where items.id = %s", item.getName(),
                Timestamp.valueOf(item.getDataTime()),
                id);
        return statement.executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = String.format("delete from items where id = %s", id);
        return statement.executeUpdate(sql) > 0;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        String sql = "select * from items";
        try (ResultSet set = statement.executeQuery(sql)) {
            while (set.next()) {
                list.add(new Item(set.getString("name"),
                        Integer.parseInt(set.getString("id")),
                        set.getTimestamp("create_time").toLocalDateTime()));
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> list = new ArrayList<>();
        String sql = String.format("select * from items where items.name = '%s'", key);
        try (ResultSet set = statement.executeQuery(sql)) {
            while (set.next()) {
                list.add(new Item(set.getString("name"),
                        Integer.parseInt(set.getString("id")),
                        set.getTimestamp("create_time").toLocalDateTime()));
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = new Item();
        String sql = String.format("select * from items where items.id = %s", id);
        try (ResultSet set = statement.executeQuery(sql)) {
            if (set.next()) {
                item.setId(Integer.parseInt(set.getString("id")));
                item.setName(set.getString("name"));
                item.setDataTime(set.getTimestamp("create_time"));
            } else {
                item = null;
            }
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
}
