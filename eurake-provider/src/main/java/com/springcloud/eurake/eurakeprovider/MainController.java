package com.springcloud.eurake.eurakeprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/10 17:30
 * @Description:
 */
@RestController
public class MainController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private HealthStatusService hsrv;

    @GetMapping("/sayHi")
    public String sayHi(){
        return "hi my port is "+port;
    }

    @GetMapping("/shutDown")
    public String shutDown(@RequestParam("status") Boolean status){
        hsrv.setStatus(status);
        return hsrv.getStatus();
    }
}
