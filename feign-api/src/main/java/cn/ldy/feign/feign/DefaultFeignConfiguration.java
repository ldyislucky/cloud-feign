package cn.ldy.feign.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {
    @Bean//设置feign的日志级别
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
