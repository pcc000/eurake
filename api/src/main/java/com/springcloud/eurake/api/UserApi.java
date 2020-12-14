package com.springcloud.eurake.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 19:25
 * @Description:
 */
@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/alive")
    public String alive();


}
