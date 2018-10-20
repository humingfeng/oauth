package com.humingfeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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



    @RequestMapping("/welcome")
    public String welcome(Model model){
        return "/manage/welcome";
    }



}
