package com.syt.cloud.inft;

import com.syt.cloud.inft.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: spring_cloud
 * @description: 基于Fegin实现的服务访问接口
 * @author: jinlu
 * @create: 2020-11-19 10:55
 **/
@FeignClient(value = "client-server",fallback = HelloServiceImpl.class) // value 指定服务 fallback 服务挂掉时断路器返回错误
public interface IHelloService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}