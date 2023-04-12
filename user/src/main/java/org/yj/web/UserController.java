package org.yj.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.yj.config.SalesProperties;
import org.yj.pojo.User;
import org.yj.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    Environment environment;





    /**
     * 使用属性注入工具，来获取属性。而属性又来自于nacos的远程配置
     */
    @Autowired
    private SalesProperties salesProperties;



    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id ,
                          @RequestHeader(value = "X-Request-red" ,required = false) String head) {
        System.out.println(environment.getProperty("local.server.port"));
        System.out.println(salesProperties.toString());
        System.out.println(head);
        if(id == 1){
            try {
                Thread.sleep(60);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return userService.queryById(id);
    }
}
