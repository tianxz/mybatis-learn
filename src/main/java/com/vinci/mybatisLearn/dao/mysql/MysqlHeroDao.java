package com.vinci.mybatisLearn.dao.mysql;

import com.vinci.mybatisLearn.annotation.MysqlMapper;
import com.vinci.mybatisLearn.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Jao on 2017/6/22.
 */
@MysqlMapper
public interface MysqlHeroDao {
    long insertUserInfo(UserInfo userInfo);

    List<UserInfo> queryUserInfo();
}
