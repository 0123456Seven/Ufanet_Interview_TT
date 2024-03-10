package ru.xaero.ufanet_coffee_task.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xaero.ufanet_coffee_task.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}

