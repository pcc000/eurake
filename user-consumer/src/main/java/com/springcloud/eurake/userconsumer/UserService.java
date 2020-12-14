package com.springcloud.eurake.userconsumer;

import com.springcloud.eurake.userapi.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/14 20:38
 * @Description:
 */
@FeignClient(name="provider")
public interface UserService extends UserApi {
}
