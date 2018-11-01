package com.humingfeng.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
     * @ProjectName:    Redis配置类-lettuce
     * @Package:        com.humingfeng.config
     * @ClassName:      RedisConfig
     * @Description:    java类作用描述
     * @Author:         胡铭锋
     * @CreateDate:     2018/11/1 16:44
     * @Version:        1.0
     */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {


    @Bean
    RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String,Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

        /**
             * JacksonJsonRedisSerializer和GenericJackson2JsonRedisSerializer，两者都能系列化成json，
             * 但是后者会在json中加入@class属性，类的全路径包名，方便反系列化。
             * 前者如果存放了List则在反系列化的时候如果没指定TypeReference则会报错java.util.LinkedHashMap cannot be cast to 。
             * @method      redisTemplate
             * @author      胡铭锋
             * @version     1.0
             * @exception
             * @date        2018/11/1 18:11
             */
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;

    }


}
