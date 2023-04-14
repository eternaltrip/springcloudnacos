package org.yj.config.loadbalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;


/**
 * 自定义的负载均衡配置（新版本弃用的robin，所以这里用loadbalancer做负载均衡）
 */
@Configuration
public class CustomLoadBalancerConfig {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                                                   LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        System.out.println("PROPERTY_NAME:>>>>>"+name);
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name , ServiceInstanceListSupplier.class) ,name);
        // return new RoundRobinLoadBalancer(loadBalancerClientFactory.getLazyProvider(name,ServiceInstanceListSupplier.class),name);
    }


}
