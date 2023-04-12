package org.yj.feign.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.yj.feign.clients.fallback.UserClientFallbackFactory;
import org.yj.feign.config.FeignDefaultConfiguration;
import org.yj.feign.pojo.User;


/**
 * FeignClient的配置可以单独设置配置，也可以在启动类上统一设置
 * @FeignClient(value = "userservice" , configuration = FeignDefaultConfiguration.class)
 */
@FeignClient(value = "userservice" ,fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {



    @GetMapping("/user/{id}")
    public User getuserById(@PathVariable("id") Long id);

}
