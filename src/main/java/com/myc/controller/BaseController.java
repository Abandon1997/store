package com.myc.controller;

import com.myc.service.ex.*;
import com.myc.utils.JsonResult;
import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

/**
 * 控制器类的基类
 */
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final int OK = 200;

    /**
     * @ExceptionHandler用于统一处理方法抛出的异常
     */
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名被占用的异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("用户的密码错误的异常");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("用户在注册过程中产生了未知的异常");
        } else if (e instanceof InsertException) {
            result.setState(5003);
            result.setMessage("更新数据时产生了未知的异常");
        }
        return result;
    }

    //获取当前用户的uid
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    //获取当前用户的用户名
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
