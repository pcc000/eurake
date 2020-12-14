package com.springcloud.eurake.eurakeconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EurakeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakeConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTeplate(){
        return new RestTemplate();
    }
}
