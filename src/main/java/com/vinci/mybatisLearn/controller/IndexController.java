package com.vinci.mybatisLearn.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vinci.mybatisLearn.dao.routing.RoutingHeroDao;
import com.vinci.mybatisLearn.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XizeTian on 2017/9/20.
 */
@RestController
@RequestMapping("/hero")
public class IndexController {

    private Map<String, DataSourceProperties> dataSourcePropertiesMap = new HashMap<>();

    @Autowired
    RoutingHeroDao routingHeroDao;
    @Autowired
    HttpSession    httpSession;

    @PostConstruct
    private void init() {
        DataSourceProperties dataSourceProperties;

        dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/mybaits.learn?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Hongkong&useSSL=false");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("root");

        dataSourcePropertiesMap.put("db1", dataSourceProperties);

        dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/mybatis.learn.x?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Hongkong&useSSL=false");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("root");

        dataSourcePropertiesMap.put("db2", dataSourceProperties);
    }

    @GetMapping("/{dataSourceKey}")
    public Page getUsers(@PathVariable("dataSourceKey") String dataSourceKey) {
        if (dataSourcePropertiesMap.containsKey(dataSourceKey)) {
            httpSession.setAttribute("data-source-key", dataSourcePropertiesMap.get(dataSourceKey));

            Page<UserInfo> users = PageHelper.startPage(1, 3);
            routingHeroDao.queryUserInfo();
            return users;
        } else {
            throw new RuntimeException("没有该数据库实例");
        }
    }
}
