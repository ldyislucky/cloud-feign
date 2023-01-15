package cn.itcast.order;

import cn.ldy.feign.clients.UserClients;
import cn.ldy.feign.feign.DefaultFeignConfiguration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaServer不需要

@EnableFeignClients //自动装配feign的开关,括号中的作用第添加feign的类
        (clients = UserClients.class,
                defaultConfiguration = DefaultFeignConfiguration.class)
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
    @Bean
    @LoadBalanced//负载均衡算法
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    /*@Bean
    public IRule randomRule (){
        return new RandomRule();
    }*/
}