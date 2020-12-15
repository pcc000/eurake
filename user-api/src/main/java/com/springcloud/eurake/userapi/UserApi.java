package com.springcloud.eurake.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 20:30
 * @Description:
 */
@RestController("/user")
public interface UserApi {

    @GetMapping("/isAlive")
    public String isAlive();

    @GetMapping("/getId")
    public Map<Integer,String> getMap(@RequestParam("id") Integer id);
}
