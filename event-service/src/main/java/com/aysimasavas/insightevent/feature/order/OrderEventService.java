package com.aysimasavas.insightevent.feature.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventService {

    @Autowired
    private final OrderEventRepository orderEventRepository;


    @Autowired
    public OrderEventService(OrderEventRepository orderEventRepository) {
        this.orderEventRepository = orderEventRepository;
    }

    public OrderEvent createOrderEvent(OrderEvent orderEvent) {
        return orderEventRepository.save(orderEvent);
    }

    public OrderEvent getOrderEventById(String id) {
        return orderEventRepository.findById(id).orElse(null);
    }

    public List<OrderEvent> getAllOrderEvents() {
        return orderEventRepository.findAll();
    }

    public OrderEvent updateOrderEvent(OrderEvent orderEvent) {
        return orderEventRepository.save(orderEvent);
    }

    public void deleteOrderEvent(String id) {
        orderEventRepository.deleteById(id);
    }
}
