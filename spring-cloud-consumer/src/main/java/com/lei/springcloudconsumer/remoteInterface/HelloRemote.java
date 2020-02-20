package com.lei.springcloudconsumer.remoteInterface;

import com.lei.springcloudconsumer.hestrix.HelloRemoteHestrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloud-producer",fallback = HelloRemoteHestrix.class)
public interface HelloRemote {
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name);
}
