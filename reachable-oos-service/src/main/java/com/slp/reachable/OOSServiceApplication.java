package com.slp.reachable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 孙乐平
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OOSServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OOSServiceApplication.class, args);
    }
}
