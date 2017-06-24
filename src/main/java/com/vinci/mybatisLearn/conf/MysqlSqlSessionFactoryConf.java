package com.vinci.mybatisLearn.conf;

import com.vinci.mybatisLearn.annotation.MysqlMapper;
import com.vinci.mybatisLearn.utils.ResourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jao on 2017/6/24.
 */

@Configuration
@MapperScan(basePackages = "com.vinci.mybatisLearn", sqlSessionFactoryRef = MysqlSqlSessionFactoryConf.SQL_SESSION_FACTORY_NAME_1, annotationClass = MysqlMapper.class)
public class MysqlSqlSessionFactoryConf {
    public static final String SQL_SESSION_FACTORY_NAME_1 = "sqlSessionFactory1";

    @Bean(name = SQL_SESSION_FACTORY_NAME_1)
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource1) throws Exception {
        Properties properties = new Properties();
        properties.put("mapUnderscoreToCamelCase", true);

        String[] mappers = new String[]{
                "classpath:ibatis/mysql/*.xml"
        };

        SqlSessionFactoryBean diSqlSessionFactoryBean = new SqlSessionFactoryBean();
        diSqlSessionFactoryBean.setDataSource(dataSource1);
        diSqlSessionFactoryBean.setMapperLocations(ResourceUtil.resolveMapperLocations(mappers));

        SqlSessionFactory sqlSessionFactory = diSqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return sqlSessionFactory;
    }
}
