package com.aysimasavas.smartstore.insightpulse.service;

import com.aysimasavas.smartstore.entity.Order;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.insightpulse.common.Constants;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;

public class OrderEventService {

    private final WebClient webClient;
    private static OrderEventService instance;

    public static OrderEventService getInstance() {
        if(instance==null)
            instance=new OrderEventService(WebClient.builder().build());
        return instance;
    }

    public OrderEventService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void orderCompleted(Order order, List<Product> products){
        HashMap<String, Object> params= new HashMap<>();
        params.put("providerId", Constants.PROVIDER_ID);
        params.put("clientId", order.getCustomerId());
        params.put("type", "ACTION");
        params.put("name", "order-completed");
        params.put("status", "SUCCESS");
        params.put("orderId", order.getId());
        params.put("products",products);
        params.put("orderPrice",products.stream().mapToDouble(p->p.getPrice().doubleValue()).sum());

        webClient.post()
                .uri(Constants.BASE_URL + "event/order")
                .bodyValue(params)
                .retrieve()
                .toBodilessEntity()
                .block();

    }

    public void orderCancelled(Order order, List<Product> products){
        HashMap<String, Object> params= new HashMap<>();
        params.put("providerId", Constants.PROVIDER_ID);
        params.put("type", "ACTION");
        params.put("name", "order-cancelled");
        params.put("status", "SUCCESS");
        params.put("orderId", order.getId());
        params.put("products",products);
        params.put("orderPrice",products.stream().mapToDouble(p->p.getPrice().doubleValue()).sum());

        webClient.post()
                .uri(Constants.BASE_URL + "event/order")
                .bodyValue(params)
                .retrieve()
                .toBodilessEntity()
                .block();

    }
}
