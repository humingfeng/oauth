package com.humingfeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.humingfeng.config.exception.CommonJsonException;
import com.humingfeng.service.LoginService;
import com.humingfeng.shiro.captcha.DreamCaptcha;
import com.humingfeng.util.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.humingfeng.constants.ErrorEnum.E_20012;

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

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private DreamCaptcha dreamCaptcha;



    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public ModelAndView login() {

        boolean authenticated = SecurityUtils.getSubject().isAuthenticated();
        logger.debug("authenticated="+authenticated);
        //已登录的直接跳转
        if(authenticated){

            logger.info("已登录");

            //已登录的需要记录认证信息



            ModelAndView mav = new ModelAndView("manage/index");
            return mav;

        }

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
    public JSONObject authLogin(@RequestBody JSONObject requestJson,HttpServletRequest request, HttpServletResponse response) {

        //验证码
        String code = requestJson.getString("code");
        boolean validate = dreamCaptcha.validate(request, response, code);

        if(!validate){
            //验证码错误
            return CommonUtil.errorJson(E_20012);
        }


        CommonUtil.hasAllRequired(requestJson, "username,password,code");
        return loginService.authLogin(requestJson);
    }


    /**
     * 图形验证码 也可以使用Kaptcha实现
     */
    @GetMapping("/captcha.jpg")
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
    @RequestMapping("/logout")
    public ModelAndView logout() {

        logger.debug("begin logout");

        loginService.logout();

        ModelAndView mv = new ModelAndView("login/index");

        return mv;
    }
}
