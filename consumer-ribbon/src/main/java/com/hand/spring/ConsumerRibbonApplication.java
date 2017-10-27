package com.hand.spring;

import com.hand.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
/**
 * 该注解表示给micro-service-user-provider这个微服务，使用RibbonConfig配置的规则来实现负载均衡
 * 该配置类中定义了随机的规则
 */
@RibbonClient(name = "micro-service-user-provider", configuration = RibbonConfig.class)
public class ConsumerRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }
}
