package com.lei.zuul;

import com.lei.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringCloudZuulApplication {


    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }


}
