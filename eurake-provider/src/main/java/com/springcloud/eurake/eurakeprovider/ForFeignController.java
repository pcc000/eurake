package com.springcloud.eurake.eurakeprovider;

import com.springcloud.eurake.api.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 19:32
 * @Description:
 */
@RestController
public class ForFeignController implements UserApi {
    @Value("${server.port}")
    private String port;

    @Override
    public String alive() {
        return "my port is "+port;
    }
}
