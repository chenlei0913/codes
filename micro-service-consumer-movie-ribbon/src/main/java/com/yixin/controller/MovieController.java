package com.yixin.controller;

import com.yixin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by asus on 2017/5/6.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
//    private DiscoveryClient discoveryClient;

    @GetMapping("/movie/{id}")
    public User findUserById(@PathVariable Long id) {
        User user = this.restTemplate.getForObject("http://micro-server-provider-user/simple/"+id, User.class);
        return user;
    }

    @GetMapping("/test")
    public void test() {
        for (int i = 0; i < 20; i++) {
            ServiceInstance instance1 =  loadBalancerClient.choose("micro-server-provider-user");
            System.out.println(String.format("服务1：ip:%s，port：%s，serviceId：", instance1.getHost(), instance1.getPort(), instance1.getServiceId()));
        }

        for (int i = 0; i < 20; i++) {
            ServiceInstance instance1 =  loadBalancerClient.choose("micro-server-provider-user1");
            System.out.println(String.format("服务2：ip:%s，port：%s，serviceId：", instance1.getHost(), instance1.getPort(), instance1.getServiceId()));
        }

    }
}
