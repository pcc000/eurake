package com.springcloud.eurake.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 20:30
 * @Description:
 */
@RestController("/user")
public interface UserApi {

    @GetMapping("/isAlive")
    public String isAlive();
}
