package ru.xaero.ufanet_coffee_task.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.xaero.ufanet_coffee_task.entity.OrderStatus;
import ru.xaero.ufanet_coffee_task.repo.OrderStatusRepository;
@Service
@Transactional
public class OrderStatusServiceImpl {
    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }
    public OrderStatus findById(Long id){
        return orderStatusRepository.findById(id).get();
    }
}
