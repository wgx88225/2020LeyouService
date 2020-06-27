package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName LyRegistry
 * @Description:
 * @Auther: vince
 * @Date: 2019/11/19 21:57
 */
@SpringBootApplication
@EnableEurekaServer
public class LyRegistry {

    public static void main(String[] args) {
        SpringApplication.run(LyRegistry.class, args);
    }
}
