package com.humingfeng.service;

import org.springframework.stereotype.Service;

/**
     * @ProjectName:    IP地址服务
     * @Package:        com.humingfeng.service
     * @ClassName:      IpAddressService
     * @Description:    java类作用描述
     * @Author:         胡铭锋
     * @CreateDate:     2018/11/2 14:52
     * @Version:        1.0
     */
@Service
public interface IpAddressService {


    /**
         * 方法实现说明
         * @method      通过IP获取所在城市
         * @author      胡铭锋
         * @version     1.0
         * @exception
         * @date        2018/11/2 14:55
         */
    public String getCityByIPAddress(String ipAddress);


}
