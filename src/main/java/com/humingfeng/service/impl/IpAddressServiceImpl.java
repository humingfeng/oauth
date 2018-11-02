package com.humingfeng.service.impl;

import com.humingfeng.service.IpAddressService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.InetAddress;


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
public class IpAddressServiceImpl implements IpAddressService {

    private static Logger logger = LoggerFactory.getLogger(IpAddressServiceImpl.class);


    private static String dbPath = "/db/GeoLite2-City.mmdb";

    private static DatabaseReader reader;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        try {
            String path = env.getProperty("geolite2.city.db.path");
            if (StringUtils.isNotBlank(path)) {
                dbPath = path;
            }
            ClassPathResource classPathResource = new ClassPathResource(path);
            reader = new DatabaseReader.Builder(classPathResource.getInputStream()).build();
        } catch (Exception e) {
            logger.error("IP地址服务初始化异常:" + e.getMessage(), e);
        }
    }


    /**
     * 方法实现说明
     * @method      通过IP获取所在城市
     * @author      胡铭锋
     * @version     1.0
     * @exception
     * @date        2018/11/2 14:55
     */
    @Override
    public String getCityByIPAddress(String ipAddress) {
        try {

            //将本地测试的过滤
            if("127.0.0.1".equals(ipAddress) || "localhost".equals(ipAddress)){
                ipAddress = "106.38.120.12";
            }

            CityResponse response = reader.city(InetAddress.getByName(ipAddress));
            return response.getMostSpecificSubdivision().getNames().get("zh-CN");
        }catch (Exception e){
            logger.error("根据IP[{}]获取省份失败:{}", ipAddress, e.getMessage());
            return null;
        }
    }
}
