package com.vinci.test.mybatisLearn;

import com.vinci.mybatisLearn.MyBatisLearnEntryProgram;
import com.vinci.mybatisLearn.dao.mysql.MysqlHeroDao;
import com.vinci.mybatisLearn.dao.postgresql.PostgresqlHeroDao;
import com.vinci.mybatisLearn.domain.UserInfo;
import com.vinci.mybatisLearn.utils.SnowflakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jao on 2017/6/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisLearnEntryProgram.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostgresqlHeroDaoTest {
    @Autowired
    MysqlHeroDao mysqlHeroDao;
    @Autowired
    PostgresqlHeroDao postgresqlHeroDao;

    @Test
    public void testInsertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(SnowflakeUtil.next());
        userInfo.setLobNumber(79101);
        userInfo.setEmailAddress("oc.mt@hotmail.com");
        userInfo.setTelNumber("02988328736");
        userInfo.setPhoneNumber("13088871919");
        long result = mysqlHeroDao.insertUserInfo(userInfo);

        assertEquals(1, result);
    }

    @Test
    public void testQueryUserInfo1() {
        List<UserInfo> result = postgresqlHeroDao.queryUserInfo();

        assertEquals(1, result.size());
    }

    @Test
    public void testQueryUserInfo2() {
        List<UserInfo> result = mysqlHeroDao.queryUserInfo();

        assertEquals(3, result.size());
    }
}
