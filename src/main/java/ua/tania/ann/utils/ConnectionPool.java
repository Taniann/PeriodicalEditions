package ua.tania.ann.utils;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Таня on 17.08.2018.
 */
public class ConnectionPool {
    private static ConnectionPool instance;

    private ResourceBundle config = ResourceBundle.getBundle("config");

    private PoolProperties properties;
    private DataSource dataSource;

    private ConnectionPool() throws SQLException {
        properties = new PoolProperties();
        properties.setDriverClassName(config.getString("config.driverClassName"));
        properties.setUrl(config.getString("config.url"));
        properties.setUsername(config.getString("config.username"));
        properties.setPassword(config.getString("config.password"));

        dataSource = new DataSource();
        dataSource.setPoolProperties(properties);
    }

    public static ConnectionPool getInstance() throws SQLException{
        if(instance == null){
            synchronized (ConnectionPool.class){
                if(instance == null){
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        return this.dataSource.getConnection();
    }
}
