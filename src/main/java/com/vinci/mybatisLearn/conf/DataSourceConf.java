package com.vinci.mybatisLearn.conf;

import com.vinci.mybatisLearn.jdbc.IcssDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Jao on 2017/6/24.
 */
@Configuration
public class DataSourceConf {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource dataSource1() {
        return dataSourceProperties1().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSourceProperties dataSourceProperties2() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSource dataSource2() {
        return dataSourceProperties2().initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource dataSource3() {
        return new IcssDataSource();
    }
}
