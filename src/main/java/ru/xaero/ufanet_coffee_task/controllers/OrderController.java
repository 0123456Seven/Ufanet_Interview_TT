package ru.xaero.ufanet_coffee_task.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xaero.ufanet_coffee_task.entity.Order;
import ru.xaero.ufanet_coffee_task.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new")
    public void newOrder(@RequestBody Order order){

        orderService.saveOrder(order);
    }
}
