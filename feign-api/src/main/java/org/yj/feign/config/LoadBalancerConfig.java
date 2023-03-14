package org.yj.feign.config;
//
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
//import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;

import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadBalancerConfig {


/*    @Bean
    public ReactiveLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment , LoadBalancerClientFactory loadBalancerClientFactory){
        String serviceId = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        System.out.println("serviceId:>>>>>"+serviceId);
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(serviceId , ServiceInstanceListSupplier.class) ,serviceId);
    }*/



}
