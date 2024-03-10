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
    public OrderEvent getAllInfo(@PathVariable(name = "id") Long id){
        return orderEventService.findById(id);
    }
    @GetMapping("/registered-info/{id}")
    public String getRegisteredInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getRegisteredInfo(id);
    }
    @GetMapping("/cancelled-info/{id}")
    public String getCancelledInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getCancelledInfo(id);
    }
    @GetMapping("/in-progress-info/{id}")
    public String getInProgressInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getInProgressInfo(id);
    }
    @GetMapping("/ready-for-pickup-info/{id}")
    public String getReadyForPickupInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getReadyInfo(id);
    }
    @GetMapping("/delivered-info/{id}")
    public String getInfo(@PathVariable(name = "id") Long id){
        return orderEventService.getDeliveredInfo(id);
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

