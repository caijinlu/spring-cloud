package com.syt.cloud.seveice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring_cloud
 * @description: 基于 restTemplate 的测试服务
 * @author: jinlu
 * @create: 2020-11-19 10:24
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")   // HystrixCommand 给该方法提供熔断功能 fallbackMethod 指定访问失败后返回的信息
    public String hiService(String name) {
        return restTemplate.getForObject("http://CLIENT-SERVER/hi?name="+name,String.class);
    }

    public String error(String name){
        return "hi,"+name+",sorry,error!";
    }
}