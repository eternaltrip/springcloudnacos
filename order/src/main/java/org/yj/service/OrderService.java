package org.yj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yj.mapper.OrderMapper;
import org.yj.pojo.Order;
import org.yj.pojo.User;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        if(order != null && order.getUserId() != null){
            User user = restTemplate.getForObject("http://userservice/user/" + order.getUserId(), User.class);
//            System.out.println(user);
            order.setUser(user);
        }

        // 4.返回
        return order;
    }
}
