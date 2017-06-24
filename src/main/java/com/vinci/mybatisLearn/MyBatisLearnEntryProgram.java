package com.vinci.mybatisLearn;

import com.vinci.mybatisLearn.annotation.PostgresqlMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Jao on 2017/6/22.
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.vinci.mybatisLearn")
public class MyBatisLearnEntryProgram {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisLearnEntryProgram.class, args);
    }
}
