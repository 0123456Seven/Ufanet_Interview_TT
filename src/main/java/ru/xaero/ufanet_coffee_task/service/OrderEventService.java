package ru.xaero.ufanet_coffee_task.service;

import ru.xaero.ufanet_coffee_task.entity.OrderEvent;

import java.util.List;

public interface OrderEventService {
    OrderEvent findById(Long id);
    List<OrderEvent> findAllByOrderId(Long orderId);
    String getRegisteredInfo(Long id);
    String getCancelledInfo(Long id);
    String getInProgressInfo(Long id);
    String getReadyInfo(Long id);
    String getDeliveredInfo(Long id);
    boolean isCancelled(Long orderId);
    boolean isDelivered(Long orderId);
    boolean isRegister(Long orderId);
    void publishEvent(OrderEvent event);
}

