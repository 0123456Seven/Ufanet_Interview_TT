package ru.xaero.ufanet_coffee_task.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.xaero.ufanet_coffee_task.entity.OrderEvent;
import ru.xaero.ufanet_coffee_task.repo.OrderEventRepository;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
@Transactional
public class OrderEventServiceImpl implements OrderEventService{
    private static final String ORDER_CANSELLED = "Заказ отменен";
    private static final String ORDER_DELIVERED = "Заказ выдан";
    private static final String ORDER_REGISTERED = "Заказ зарегистрирован";
    @PersistenceContext
    private EntityManager entityManager;
    private final OrderEventRepository orderEventRepository;



    public OrderEventServiceImpl(OrderEventRepository orderEventRepository) {
        this.orderEventRepository = orderEventRepository;
    }
    public OrderEvent findById(Long id) {
        return orderEventRepository.findById(id).get();
    }
    public List<OrderEvent> findAllByOrderId(Long orderId) {
        String hql = "FROM OrderEvent oe WHERE oe.order.id = :orderId";
        Query query = entityManager.createQuery(hql);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    public String getRegisteredInfo(Long id){
        OrderEvent orderEvent = findById(id);
        Long orderId = orderEvent.getOrder().getId();
        Long customerId = orderEvent.getOrder().getClientId();
        Long employeeId = orderEvent.getOrder().getEmployee().getId();
        LocalTime waitTime = LocalTime.now().withSecond(0).withNano(0).plusMinutes(orderEvent.getOrder().getWaitTime().getTime());
        Long productId = orderEvent.getOrder().getProduct().getId();
        Long productPrice = orderEvent.getOrder().getProduct().getPrice();
        LocalDateTime dateTime = orderEvent.getEventTime();
        String info = "Статус заказа : "+orderEvent.getOrderStatus().getOrderStatus()+
                "\nИдентификатор заказа = "+orderId+"" +
                "\nИдентификатор клиента = "+customerId+
                "\nИдентификатор сотрудника = "+employeeId+
                "\nОжидаемое время выдачи = "+waitTime+
                "\nИдентификатор товара = "+productId+
                "\nСтоимость товара = "+productPrice+
                "\nДата и время = "+dateTime;
        return info;
    }
    public String getCancelledInfo(Long id){
        OrderEvent orderEvent = findById(id);
        Long orderId = orderEvent.getOrder().getId();
        Long customerId = orderEvent.getOrder().getClientId();
        Long employeeId = orderEvent.getOrder().getEmployee().getId();
        String cancelReason = orderEvent.getCancelReason();
        LocalDateTime dateTime = orderEvent.getEventTime();
        String info = "Статус заказа : "+orderEvent.getOrderStatus().getOrderStatus()+
                "\nИдентификатор заказа = "+orderId+"" +
                "\nИдентификатор клиента = "+customerId+
                "\nИдентификатор сотрудника = "+employeeId+
                "\nПричина отмены заказа = "+cancelReason+
                "\nДата и время = "+dateTime;
        return info;
    }
    public String getInProgressInfo(Long id){
        OrderEvent orderEvent = findById(id);
        Long orderId = orderEvent.getOrder().getId();
        Long employeeId = orderEvent.getOrder().getEmployee().getId();
        LocalDateTime dateTime = orderEvent.getEventTime();
        String info = "Идентификатор заказа = "+orderId+"" +
                "\nИдентификатор сотрудника = "+employeeId+
                "\nДата и время = "+dateTime;
        return info;
    }
    public String getReadyInfo(Long id){
        OrderEvent orderEvent = findById(id);
        Long orderId = orderEvent.getOrder().getId();
        Long employeeId = orderEvent.getOrder().getEmployee().getId();
        LocalDateTime dateTime = orderEvent.getEventTime();
        String info = "Идентификатор заказа = "+orderId+"" +
                "\nИдентификатор сотрудника = "+employeeId+
                "\nДата и время = "+dateTime;
        return info;
    }
    public String getDeliveredInfo(Long id){
        OrderEvent orderEvent = findById(id);
        Long orderId = orderEvent.getOrder().getId();
        Long employeeId = orderEvent.getOrder().getEmployee().getId();
        LocalDateTime dateTime = orderEvent.getEventTime();
        String info = "Идентификатор заказа = "+orderId+"" +
                "\nИдентификатор сотрудника = "+employeeId+
                "\nДата и время = "+dateTime;
        return info;
    }

    public boolean isCancelled(Long orderId){
        boolean isCancel = false;
        List<OrderEvent> orderEvents = findAllByOrderId(orderId);
        for(OrderEvent orderEvent : orderEvents){
            if(orderEvent.getOrderStatus().getOrderStatus().equals(ORDER_CANSELLED)){
                isCancel = true;
            }
            else{
                isCancel = false;
            }
        }
        return isCancel;
    }
    public boolean isDelivered(Long orderId) {
        boolean isDelivered = false;
        List<OrderEvent> orderEvents = findAllByOrderId(orderId);
        for(OrderEvent orderEvent : orderEvents){
            if(orderEvent.getOrderStatus().getOrderStatus().equals(ORDER_DELIVERED)){
                isDelivered = true;
            }
            else{
                isDelivered = false;
            }
        }
        return isDelivered;
    }
    public boolean isRegister(Long orderId) {
        List<OrderEvent> orderEvents = findAllByOrderId(orderId);
        if (orderEvents == null || orderEvents.isEmpty()) {
            return false;
        } else {
            for (OrderEvent orderEvent : orderEvents) {
                if (orderEvent.getOrderStatus().getOrderStatus().equals(ORDER_REGISTERED)) {
                    return true;
                }
            }
            return false;
        }
    }



    public void publishEvent(OrderEvent event) {
        Long orderId = event.getOrder().getId();

        if (isRegister(orderId)) {
            if (!isCancelled(orderId) && !isDelivered(orderId)) {
                orderEventRepository.save(event);
                System.out.println("Событие успешно добавлено");
            } else {
                System.out.println("Невозможно добавить новое событие. Заказ отменен или выдан.");
            }
        } else {
            System.out.println("Невозможно добавить событие. Должно предшествовать событие регистрации заказа.");
        }
    }




}
