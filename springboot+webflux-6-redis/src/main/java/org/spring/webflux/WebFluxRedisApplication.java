package org.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class WebFluxRedisApplication {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(WebFluxRedisApplication.class,args);
    }
}
