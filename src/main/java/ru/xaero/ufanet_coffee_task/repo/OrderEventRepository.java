package ru.xaero.ufanet_coffee_task.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xaero.ufanet_coffee_task.entity.OrderEvent;

@Repository
public interface OrderEventRepository extends CrudRepository<OrderEvent, Long> {

}

