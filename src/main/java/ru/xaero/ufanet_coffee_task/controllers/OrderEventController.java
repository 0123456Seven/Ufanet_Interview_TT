package ru.xaero.ufanet_coffee_task.controllers;

import org.springframework.web.bind.annotation.*;
import ru.xaero.ufanet_coffee_task.entity.OrderEvent;
import ru.xaero.ufanet_coffee_task.service.OrderEventServiceImpl;


import java.util.List;


@RestController
@RequestMapping("/order-events")
public class OrderEventController {

    private final OrderEventServiceImpl orderEventService;

    public OrderEventController(OrderEventServiceImpl orderEventService) {
        this.orderEventService = orderEventService;

    }

    @GetMapping("/all-info/{id}")
    public OrderEvent getJsonInfo(@PathVariable(name = "id") Long id){
        return orderEventService.findById(id);
    }
    @GetMapping("/info/{id}")
    public StringBuilder getAllInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getInfo(id);
    }
    @GetMapping("/find-all/{id}")
    public List<OrderEvent> findAllByOrderId(@PathVariable(name = "id") Long id){
        return orderEventService.findAllByOrderId(id);
    }
    @PostMapping("/publish-event")
    public void publishEvent(@RequestBody OrderEvent orderEvent){
        orderEventService.publishEvent(orderEvent);
    }




}

