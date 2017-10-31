package com.hand.spring.controller;

import com.hand.spring.bean.User;
import com.hand.spring.feign.UserFeignClient1;
import com.hand.spring.feign.UserFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joker on 2017/10/31.
 */
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient1 userFeignClient1;

    @Autowired
    private UserFeignClient2 userFeignClient2;


    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient1.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }

}
