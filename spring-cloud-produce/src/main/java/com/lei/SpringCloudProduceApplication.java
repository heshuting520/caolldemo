package com.lei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProduceApplication.class, args);
    }

}
