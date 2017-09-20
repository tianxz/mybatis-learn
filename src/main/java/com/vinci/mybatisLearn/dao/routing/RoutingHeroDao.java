package com.vinci.mybatisLearn.dao.routing;

import com.vinci.mybatisLearn.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by XizeTian on 2017/9/20.
 */
@Mapper
public interface RoutingHeroDao {
    long insertUserInfo(UserInfo userInfo);

    List<UserInfo> queryUserInfo();
}
