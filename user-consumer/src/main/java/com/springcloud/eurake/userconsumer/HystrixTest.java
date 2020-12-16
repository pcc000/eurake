package com.springcloud.eurake.userconsumer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/15 19:53
 * @Description:
 */
public class HystrixTest extends HystrixCommand {

    @Override
    protected Object getFallback() {
        return "getFallbackgetFallback";
    }

    protected HystrixTest(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object run() throws Exception {
        System.out.println("执行逻辑");
        return "ok";
    }

    public static void main(String[] args) {
        Future<String> futureResult = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("123123")).queue();
        String result = "";
        try {
            result = futureResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("程序结果："+result);
    }
}
