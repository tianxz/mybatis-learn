package com.vinci.mybatisLearn.controll;

import com.vinci.mybatisLearn.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jao on 2017/6/22.
 */
@Controller
@RequestMapping("/user1")
public class UserInfoController {
    UserInfo userInfo;

    @RequestMapping
    @ResponseBody
    public void addUser() {

    }
}
