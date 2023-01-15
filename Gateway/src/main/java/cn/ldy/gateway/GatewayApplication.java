package cn.ldy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : ldy
 * @version : 1.0
 */
@SpringBootApplication//springboot启动注解
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
