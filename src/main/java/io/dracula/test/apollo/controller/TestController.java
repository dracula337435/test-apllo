package io.dracula.test.apollo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String printHello(){
        return "来自配置中心的属性值，hello = "+hello;
    }

    @Autowired
    private TestProperties testProperties;

    @GetMapping("printProps")
    public String printProps(){
        return "来自配置中心，ConfigurationPropeties中，test中的some = "+testProperties.getSome();
    }

}
