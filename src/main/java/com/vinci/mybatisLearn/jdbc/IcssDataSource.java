package com.vinci.mybatisLearn.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XizeTian on 2017/9/20.
 */
public class IcssDataSource extends AbstractRoutingDataSource {
    private Map<Object, Object> dataSourceMap = new HashMap<>();

    public IcssDataSource() {
        super.setTargetDataSources(dataSourceMap);
    }

    @Autowired
    HttpSession httpSession;

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceProperties dataSourceKey = (DataSourceProperties) httpSession.getAttribute("data-source-key");
        if (!dataSourceMap.containsKey(dataSourceKey.hashCode())) {
            dataSourceMap.put(dataSourceKey.hashCode(), buildDataSourceByKey(dataSourceKey));
        }
        return dataSourceKey.hashCode();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Object     lookupKey  = determineCurrentLookupKey();
        DataSource dataSource = (DataSource) this.dataSourceMap.get(lookupKey);
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
        }
        return dataSource;
    }

    private DataSource buildDataSourceByKey(DataSourceProperties dataSourceProperties) {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setMaxActive(8);
        dataSource.setMinIdle(1);
        dataSource.setInitialSize(1);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        return dataSource;
    }
}
