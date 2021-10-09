package com.assessment.sportyshoes.users;

import com.assessment.sportyshoes.orders.Order;
import com.assessment.sportyshoes.orders.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final OrderService orderService;

    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping(path = "order")
//    public void order(@RequestBody Order order){
//
//        System.out.println(order.getUser());
//        orderService.order(order);
//    }


}
