package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

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
        createTable();
    }

    private void createTable() throws SQLException {
        try (PreparedStatement preparedStatement = cn.prepareStatement("create table if not exists items(id serial primary key, name text, create_time timestamp)")) {
            preparedStatement.execute();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement preparedStatement = cn.prepareStatement("insert into items(name, create_time) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getDataTime()));
            preparedStatement.execute();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        try (PreparedStatement preparedStatement = cn.prepareStatement("update items set name = ?, create_time = ? where items.id = ?")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getDataTime()));
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement preparedStatement = cn.prepareStatement("delete from items where items.id = ?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items")) {
            try (ResultSet set = preparedStatement.executeQuery()) {
                while (set.next()) {
                    list.add(getItem(set));
                }
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items where items.name = ?")) {
            preparedStatement.setString(1, key);
            try (ResultSet set = preparedStatement.executeQuery()) {
                while (set.next()) {
                    list.add(getItem(set));
                }
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items where items.id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet set = preparedStatement.executeQuery()) {
                if (set.next()) {
                    item = getItem(set);
                }
            }
        }
        return item;
    }

    private Item getItem(ResultSet set) throws SQLException {
        Item item = new Item();
        item.setId(Integer.parseInt(set.getString("id")));
        item.setName(set.getString("name"));
        item.setDataTime(set.getTimestamp("create_time"));
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

}
