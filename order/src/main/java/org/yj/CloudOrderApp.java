package org.yj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.yj.feign.clients.UserClient;
import org.yj.feign.config.FeignDefaultConfiguration;

/**
 * LoadBalancerClient是针对要访问的服务做负载均衡配置。
 * 比如要访问userservice这个服务，这里就要配置负载均衡设置
 *
 */


@EnableFeignClients(clients = {UserClient.class} ,defaultConfiguration = FeignDefaultConfiguration.class)

// @EnableFeignClients(basePackages = "org.yj") //这里可以通过扫描路径的方式，把所有的feign都导入
@SpringBootApplication
public class CloudOrderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(CloudOrderApp.class,args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
