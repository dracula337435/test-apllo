package io.dracula.test.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${hello}")
    private String hello;

    @GetMapping("sayHello")
    public String sayHello(@RequestParam("name") String name){
        return "hello "+hello+" "+name;
    }

}
