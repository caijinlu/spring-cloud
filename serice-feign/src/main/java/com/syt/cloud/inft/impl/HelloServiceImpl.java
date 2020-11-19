package com.syt.cloud.inft.impl;

import com.syt.cloud.inft.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @program: spring_cloud
 * @description: 基于Feign的熔断服务实现类
 * @author: jinlu
 * @create: 2020-11-19 11:17
 **/
@Component
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}