package org.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebFluxRedisCacheApplication {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(WebFluxRedisCacheApplication.class, args);
    }
}
