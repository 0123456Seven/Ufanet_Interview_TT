package ru.xaero.ufanet_coffee_task.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.xaero.ufanet_coffee_task.entity.Order;
import ru.xaero.ufanet_coffee_task.entity.OrderEvent;
import ru.xaero.ufanet_coffee_task.repo.OrderEventRepository;
import ru.xaero.ufanet_coffee_task.repo.OrderRepository;
import ru.xaero.ufanet_coffee_task.repo.OrderStatusRepository;

import java.time.LocalDateTime;

@Service
@Transactional
public class OrderServiceImpl{
    private final OrderRepository orderRepository;
    private final OrderStatusServiceImpl orderStatusService;
    private final OrderEventRepository orderEventRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderStatusRepository orderStatusRepository, OrderStatusServiceImpl orderStatusService, OrderEventRepository orderEventRepository) {
        this.orderRepository = orderRepository;
        this.orderStatusService = orderStatusService;
        this.orderEventRepository = orderEventRepository;
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setOrderStatus(orderStatusService.findById(3L));
        orderEvent.setEventTime(LocalDateTime.now().withSecond(0).withNano(0));
        orderEventRepository.save(orderEvent);
        System.out.println("Заказ успешно добавлен");
    }

}
