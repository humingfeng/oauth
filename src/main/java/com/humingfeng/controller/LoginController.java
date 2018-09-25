package com.humingfeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.humingfeng.service.LoginService;
import com.humingfeng.shiro.captcha.DreamCaptcha;
import com.humingfeng.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*@ClassName     LoginController
*@description   登录相关Controller
*@author        胡铭锋
*@Date          2018/9/24 22:48
*@Version       1.0
**/
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private DreamCaptcha dreamCaptcha;

    @RequestMapping("/")
    public ModelAndView resList() {

        ModelAndView mav = new ModelAndView("login/index");
        return mav;

    }

    /**
     * 登录
     *
     * @param requestJson
     * @return
     */
    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username,password");
        return loginService.authLogin(requestJson);
    }


    /**
     * 图形验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        dreamCaptcha.generate(request, response);
    }


    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
