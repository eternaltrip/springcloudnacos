package org.yj.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignDefaultConfiguration {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.BASIC;
    }

}
