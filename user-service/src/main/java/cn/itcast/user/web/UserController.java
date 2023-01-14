package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope//实现热更新 不需要重启服务器就可以更新配置
public class UserController {
    /**
     * 路径： /user/1
     *
     * //@param id 用户id
     * @return 用户
     */
    @Autowired
    private UserService userService;


    @GetMapping("prop")
    public PatternProperties properties(){
        return patternProperties;
    }

    @Autowired
    private PatternProperties patternProperties;//通过配置的文件PatternProperties读取nacos的配置
    @GetMapping("now2")//推荐的使用方法，热更新不需要额外注解
    public String now2(){
        return LocalDateTime.now().
                format(DateTimeFormatter.ofPattern(patternProperties.toString()));
    }


   // @Value("${pattern.dateformat}")//读取nacos中的配置文件,这个配置环境是在dev中配置的，但是其它环境并没有配置，所以如果在test或者其它环境中启动的话，那么这一行代码就会报错
    private String date;
    @GetMapping("now")//不推荐的方法  实现热（不重启）更新需要打开@RefreshScope注解
    public String now(){
        return LocalDateTime.now().
                format(DateTimeFormatter.ofPattern(date));
    }

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
