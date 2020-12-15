package com.springcloud.eurake.eurakeprovider;

import com.springcloud.eurake.userapi.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

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
    public String isAlive() {
        return "my port is "+port;
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return Collections.singletonMap(id,"123123123");
    }
}
