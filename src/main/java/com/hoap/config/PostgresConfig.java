package com.hoap.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.hoap.util.IConstants.DECRYPT_KEY;
import static com.hoap.util.IConstants.POSTGRES_POOL;
@Configuration
public class PostgresConfig extends DataSourceConfig {
    private static final Logger logger = LogManager.getLogger(PostgresConfig.class);
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String dataSourceURL;
    @Value("${spring.datasource.username}")
    private String dbUserName;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource dataSource() throws SQLException {
        logger.debug("Driver " + driver);
        logger.debug("DataSourceURL: " + dataSourceURL);

        String decrypt_key = env.getProperty(DECRYPT_KEY);
        //dbUserName = AppUtil.decryptData(dbUserName, decrypt_key);
        // dbPassword = AppUtil.decryptData(dbPassword, decrypt_key);

        return getDataSource(dataSourceURL, dbUserName, dbPassword, driver, POSTGRES_POOL);
    }

    @DependsOn("jdbcTemplate")
    @Bean("namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate) throws SQLException {
        logger.debug("jdbcTemplate: " + jdbcTemplate);
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }
}
