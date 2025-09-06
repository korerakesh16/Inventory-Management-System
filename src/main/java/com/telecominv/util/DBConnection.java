package com.telecominv.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {
    private static HikariDataSource dataSource;

    static {
        try {
            HikariConfig config = new HikariConfig();

            // ✅ Correct MySQL 8 URL
            config.setJdbcUrl("jdbc:mysql://localhost:3306/telecom_inventory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
            
            // ✅ MySQL credentials
            config.setUsername("root");        // your MySQL username
            config.setPassword("komala");      // your MySQL password

            // ✅ Important: set MySQL 8 driver
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");

            // ✅ Connection pool tuning
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            dataSource = new HikariDataSource(config);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing DB connection: " + e.getMessage());
        }
    }

    // ✅ Get connection
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
