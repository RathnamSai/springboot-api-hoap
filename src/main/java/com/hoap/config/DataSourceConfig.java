package com.hoap.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceConfig {

    public static DataSource getDataSource(String dataSourceURL, String dbUserName, String dbPassword,
                                           String driverClass, String poolName) {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(dataSourceURL);
        ds.setUsername(dbUserName);
        ds.setPassword(dbPassword);
        ds.setDriverClassName(driverClass);
        ds.setPoolName(poolName);
        ds.setMinimumIdle(2);
        ds.setMaxLifetime(600000);
        ds.setMaximumPoolSize(100);
        ds.setLeakDetectionThreshold(30000);
        return ds;
    }
}
