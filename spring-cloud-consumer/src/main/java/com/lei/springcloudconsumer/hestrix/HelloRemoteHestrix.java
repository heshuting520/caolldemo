package com.lei.springcloudconsumer.hestrix;

import com.lei.springcloudconsumer.remoteInterface.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHestrix implements HelloRemote {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello"+name+"服务掉线，访问失败";
    }
}
