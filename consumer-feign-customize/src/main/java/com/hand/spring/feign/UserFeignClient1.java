package com.hand.spring.feign;

import com.hand.config.Configuration1;
import com.hand.spring.bean.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Joker on 2017/10/31.
 */
@FeignClient(name = "micro-service-user-provider2", configuration = Configuration1.class)
public interface UserFeignClient1 {
    @RequestLine("GET /user/{id}")
    User findById(@Param("id") Long id);//注意这里不要用@PathVariable注解

}
