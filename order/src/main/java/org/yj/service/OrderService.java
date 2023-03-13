package org.yj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yj.clients.UserClient;
import org.yj.mapper.OrderMapper;
import org.yj.pojo.Order;
import org.yj.pojo.User;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 使用feign组件来实现外部接口的访问
     */
    @Autowired
    private UserClient userClient;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        if(order != null && order.getUserId() != null){
//            User user = restTemplate.getForObject("http://userservice/user/" + order.getUserId(), User.class);

            User user = userClient.getuserById(order.getUserId());

//            System.out.println(user);
            order.setUser(user);
        }

        // 4.返回
        return order;
    }
}
