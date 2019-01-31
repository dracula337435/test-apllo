package io.dracula.test.apollo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dk
 */
@ConfigurationProperties("test")
public class TestProperties {

    private String some;

    public String getSome() {
        return some;
    }

    public void setSome(String some) {
        this.some = some;
    }
}
