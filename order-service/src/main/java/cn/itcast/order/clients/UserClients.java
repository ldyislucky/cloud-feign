package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : ldy
 * @version : 1.0
 */
@FeignClient("userserver")//指定服务名称
public interface UserClients {
    @GetMapping("/user/{id}")
    User findId(@PathVariable("id")long id);//@PathVariable的作用是绑定{id}和long id
}
