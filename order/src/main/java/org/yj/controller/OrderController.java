package org.yj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yj.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("{orderId}")
    public Object getOrderById(@PathVariable("orderId") Long orderId ,
                               @RequestHeader(value = "X-Request-red" ,required = false) String head) {
        System.out.println(head);
        return orderService.queryOrderById(orderId);
    }


}
