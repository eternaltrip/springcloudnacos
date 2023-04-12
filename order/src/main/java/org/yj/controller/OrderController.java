package org.yj.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yj.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @SentinelResource("hot")
    @GetMapping("{orderId}")
    public Object getOrderById(@PathVariable("orderId") Long orderId ,
                               @RequestHeader(value = "X-Request-red" ,required = false) String head) {
        System.out.println("head :"+head);
        return orderService.queryOrderById(orderId);
    }


    @GetMapping("/update")
    public Object updateOrderById() {
        return "更新成功";
    }

    @GetMapping("/query")
    public Object queryOrderById() {
        orderService.queryGoods();
        return "查询";
    }

    @GetMapping("/save")
    public Object save() {
        orderService.queryGoods();
        return "保持成功";
    }


}
