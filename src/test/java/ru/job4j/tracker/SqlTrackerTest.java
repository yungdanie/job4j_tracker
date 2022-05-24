package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName("item").get(0), is(item));
    }

    @Test
    public void whenSaveItemAndReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item newItem = new Item("newItem");
        tracker.add(item);
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is(newItem.getName()));
    }

    @Test
    public void whenSaveItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findAll().get(0), is(item));
        assertThat(tracker.findAll().get(1), is(item1));
    }

    @Test
    public void whenSaveItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }
}