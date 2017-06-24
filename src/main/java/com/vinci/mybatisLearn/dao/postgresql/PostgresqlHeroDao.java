package com.vinci.mybatisLearn.dao.postgresql;

import com.vinci.mybatisLearn.annotation.PostgresqlMapper;
import com.vinci.mybatisLearn.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jao on 2017/6/22.
 */
@PostgresqlMapper
public interface PostgresqlHeroDao {
    long insertUserInfo(UserInfo userInfo);

    List<UserInfo> queryUserInfo();
}
