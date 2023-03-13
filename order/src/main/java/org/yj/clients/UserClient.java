package org.yj.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.yj.pojo.User;

@FeignClient("userservice")
public interface UserClient {




    @GetMapping("/user/{id}")
    public User getuserById(@PathVariable("id") Long id);

}
