package com.hand.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Joker on 2017/10/31.
 */
@Configuration
public class Configuration1 {
    //使用feign默认的注解形式
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
