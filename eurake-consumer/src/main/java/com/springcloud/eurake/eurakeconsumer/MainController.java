package com.springcloud.eurake.eurakeconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/12/11 17:48
 * @Description:
 */
@RestController
public class MainController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private EurekaClient eurekaClient;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/client")
    public String client(){
        List<String> services = discoveryClient.getServices();
        for(String str : services){
            System.out.println(str);
        }

        List<InstanceInfo> instanceInfoList = eurekaClient.getInstancesById("192.168.239.1:provider:81");
        for(InstanceInfo info : instanceInfoList){
            System.out.println("eurekaClient info:"+ ToStringBuilder.reflectionToString(info));
        }

        List<ServiceInstance> lists = discoveryClient.getInstances("provider");
        for(ServiceInstance str : lists){
            System.out.println(ToStringBuilder.reflectionToString(str));
        }

        return "ok";
    }


    @GetMapping("/getPort")
    public String getPort(){

        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        System.out.println(ToStringBuilder.reflectionToString(serviceInstance));
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/sayHi";
        RestTemplate restTemplate1 = new RestTemplate();
        String reusl = restTemplate1.getForObject(url,String.class);
        return reusl;
    }

    @GetMapping("/showDown")
    public String showDown(){
        String url =  "http://PROVIDER/showDown";
        String reusl = restTemplate.getForObject(url,String.class);
        return reusl;
    }

    @GetMapping("/client1")
    public String client1(){
        String url =  "http://PROVIDER/sayHi";
        String reusl = restTemplate.getForObject(url,String.class);
        return reusl;
    }
}
