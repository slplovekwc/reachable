package com.slp.reachable;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.slp.reachable.mapper")
@EnableScheduling
public class MyApplication_8090 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication_8090.class, args);
        System.out.println(run);
    }
}
