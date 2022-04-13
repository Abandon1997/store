package com.myc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myc.entity.User;
import com.myc.service.UserService;
import com.myc.service.ex.InsertException;
import com.myc.service.ex.UsernameDuplicateException;
import com.myc.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password) {
        User data = userService.login(username, password);
        return new JsonResult<>(OK, data);
    }
    /*public JsonResult<Void> reg(User user) {
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDuplicateException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } catch (InsertException e) {
            result.setState(5000);
            result.setMessage("用户在注册过程中产生了未知的异常");
        }

        return result;
    }*/
}
