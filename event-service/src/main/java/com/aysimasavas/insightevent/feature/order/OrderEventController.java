package com.aysimasavas.insightevent.feature.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event/order")
public class OrderEventController {

    private final OrderEventService orderEventService;

    public OrderEventController(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }


    @PostMapping
    public ResponseEntity<OrderEvent> createOrderEvent(@RequestBody OrderEvent orderEvent) {
        OrderEvent createdOrderEvent = orderEventService.createOrderEvent(orderEvent);
        return new ResponseEntity<>(createdOrderEvent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEvent> getOrderEventById(@PathVariable String id) {
        OrderEvent orderEvent = orderEventService.getOrderEventById(id);
        if (orderEvent != null) {
            return new ResponseEntity<>(orderEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderEvent>> getAllOrderEvents() {
        List<OrderEvent> orderEvents = orderEventService.getAllOrderEvents();
        return new ResponseEntity<>(orderEvents, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderEvent> updateOrderEvent(@RequestBody OrderEvent orderEvent) {
        OrderEvent updatedOrderEvent = orderEventService.updateOrderEvent(orderEvent);
        return new ResponseEntity<>(updatedOrderEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderEvent(@PathVariable String id) {
        orderEventService.deleteOrderEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

