package com.yixin.controller;

import com.yixin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/movie/{id}")
    public User findUserById(@PathVariable Long id) {
        User user = this.restTemplate.getForObject("http://127.0.0.1:7900/simple/"+id, User.class);
        return user;
    }
}
