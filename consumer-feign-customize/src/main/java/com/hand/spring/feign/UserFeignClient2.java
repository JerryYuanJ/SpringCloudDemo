package com.hand.spring.feign;

import com.hand.config.Configuration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Joker on 2017/10/31.
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface UserFeignClient2 {
    //这里的serviceName是appName,不是spring.application.name的值
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
