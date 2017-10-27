package com.hand.spring.controller;

import com.hand.spring.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Joker on 2017/10/10.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return restTemplate.getForObject("http://micro-service-user-provider/user/" + id, User.class);
    }

    @GetMapping("/test")
    public String test(){
        /*
         * 用micro-service-user-provider启两个端口不同的微服务
         * 用micro-service-user-provider2启两个端口不同的微服务
         * 通过打印的结果来看：
         * micro-service-user-provider采用的是随机的算法，micro-service-user-provider2采用的是默认的轮询算法
         */
        ServiceInstance instance1 = loadBalancerClient.choose("micro-service-user-provider");
        System.out.println("1===>"+instance1.getHost()+":"+instance1.getPort()+":"+instance1.getServiceId());

        ServiceInstance instance2 = loadBalancerClient.choose("micro-service-user-provider2");
        System.out.println("2===>"+instance2.getHost()+":"+instance2.getPort()+":"+instance2.getServiceId());

        return "hello";
    }
}
