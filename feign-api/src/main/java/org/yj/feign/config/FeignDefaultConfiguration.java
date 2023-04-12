package org.yj.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.yj.feign.clients.fallback.UserClientFallbackFactory;

public class FeignDefaultConfiguration {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    public UserClientFallbackFactory getUserClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }

}
