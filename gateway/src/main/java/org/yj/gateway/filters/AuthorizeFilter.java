package org.yj.gateway.filters;

import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * 全局过滤器，这里和配置文件中不一样的地方在于，这里可以根据各种条件来做判断
 * 并设置order（-1）最高级别
 *
 */
@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter {


    /**
     *这里可以通过参数中是否有特定的值，来实现权限的判断
     * @param exchange 请求中的上线文
     * @param chain 下一个过滤器
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求，
        ServerHttpRequest request = exchange.getRequest();
        //2.获取参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //3.判断参数
        String authorization= queryParams.getFirst("authorization");

        //4.决定是否放行
        if("admin".equals(authorization)){
            //4放行
            return chain.filter(exchange);
        }
        //拒绝，并设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        //返回
        return exchange.getResponse().setComplete();
    }
}
