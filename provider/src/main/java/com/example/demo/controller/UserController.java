package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joker on 2017/10/10.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @GetMapping("eureka-server")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("micro-service-user-provider", true);
        return instance.getIPAddr() + ":" + instance.getAppName();
    }

    @GetMapping("instance-info")
    public ServiceInstance instanceInfo() {
        ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
        return instance;
    }
}
