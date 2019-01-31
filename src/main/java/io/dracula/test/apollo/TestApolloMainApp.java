package io.dracula.test.apollo;

import io.dracula.test.apollo.controller.TestProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author dk
 */
@SpringBootApplication
@EnableConfigurationProperties(TestProperties.class)
public class TestApolloMainApp {

    public static void main(String[] args){
        SpringApplication.run(TestApolloMainApp.class, args);
    }

}
