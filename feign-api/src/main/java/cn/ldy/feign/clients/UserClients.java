package cn.ldy.feign.clients;

import cn.ldy.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : ldy
 * @version : 1.0
 */
@Component
@FeignClient("userserver")//指定服务名称
public interface UserClients {
    @GetMapping("/user/{id}")
    User findId(@PathVariable("id")long id);//@PathVariable的作用是绑定{id}和long id
}
