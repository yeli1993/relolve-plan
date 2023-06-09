package com.yl.test;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Log4j2
@SpringBootApplication(scanBasePackages = {"com.yl"})
public class TestApplication {

    @Value("${server.port}")
    private String port;

    private static String portValue;

    @PostConstruct
    public void setPortValue() {
        portValue = this.port;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        StringBuffer sb = new StringBuffer();
        sb.append("登录访问：").append("http://localhost:").append(portValue).append("/");

        log.info(sb.toString());

    }

}
