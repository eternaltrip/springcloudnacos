package org.yj.feign.clients.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.yj.feign.clients.UserClient;
import org.yj.feign.pojo.User;


@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User getuserById(Long id) {
                log.error("查询用户异常",throwable);
                return new User();
            }
        };
    }
}
