package com.humingfeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡铭锋
 * @ClassName ManageController
 * @description TODO
 * @Date 2018/9/27 23:22
 * @Version 1.0
 **/

@Controller
@RequestMapping("/manage")
public class ManageController {

    private Logger logger = LoggerFactory.getLogger(ManageController.class);



    /**
         * 方法实现说明
         * @method      后台首页数据展示
         * @author      胡铭锋
         * @version     1.0
         * @exception
         * @date        2018/10/29 18:01
         */
    @RequestMapping("/welcome")
    public String welcome(Model model){

        //查询权限认证登录信息

        Map<String,String> map = new HashMap<>();
        map.put("lastMonthAverageValue","99.9%");

        model.addAllAttributes(map);


        return "/manage/welcome";
    }



}
