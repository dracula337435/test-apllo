package io.dracula.test.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dk
 */
@RestController
public class TestController {

    @Value("${hello}")
    private String hello;

    @GetMapping("printHello")
    public String sayHello(){
        return "来自配置中心的属性值，hello = "+hello;
    }

}
