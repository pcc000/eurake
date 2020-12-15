package com.springcloud.eurake.userconsumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 20:39
 * @Description:
 */
@RestController
public class MainController {

    @Resource
    private UserService userService;

    @RequestMapping("/isAlive")
    private String isAlive(){
        return userService.isAlive();
    }

    @RequestMapping("/getId")
    public Map<Integer,String> getId(@RequestParam("id") Integer id){
        return userService.getMap(id);
    }
}
