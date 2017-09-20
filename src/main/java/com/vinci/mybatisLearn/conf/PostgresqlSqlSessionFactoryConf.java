package com.vinci.mybatisLearn.conf;

import com.github.pagehelper.PageInterceptor;
import com.vinci.mybatisLearn.annotation.PostgresqlMapper;
import com.vinci.mybatisLearn.utils.ResourceUtil;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jao on 2017/6/24.
 */
@Configuration
@MapperScan(basePackages = "com.vinci.mybatisLearn", sqlSessionFactoryRef = PostgresqlSqlSessionFactoryConf.SQL_SESSION_FACTORY_NAME_2, annotationClass = PostgresqlMapper.class)
public class PostgresqlSqlSessionFactoryConf {
    public static final String SQL_SESSION_FACTORY_NAME_2 = "sqlSessionFactory2";

    @Bean(name = SQL_SESSION_FACTORY_NAME_2)
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource2) throws Exception {
        String[] mappers = new String[]{
                "classpath:ibatis/postgresql/*.xml"
        };

        Properties pageInterceptorProperties = new Properties();
        pageInterceptorProperties.setProperty("helperDialect", "postgresql");

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(pageInterceptorProperties);

        Interceptor[] interceptors = new Interceptor[]{
                pageInterceptor
        };

        Properties properties = new Properties();
        properties.put("mapUnderscoreToCamelCase", true);

        SqlSessionFactoryBean diSqlSessionFactoryBean = new SqlSessionFactoryBean();
        diSqlSessionFactoryBean.setDataSource(dataSource2);
        diSqlSessionFactoryBean.setMapperLocations(ResourceUtil.resolveMapperLocations(mappers));
        diSqlSessionFactoryBean.setPlugins(interceptors);

        SqlSessionFactory sqlSessionFactory = diSqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

        return sqlSessionFactory;
    }
}
