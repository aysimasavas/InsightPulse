package com.aysimasavas.smartstore.insightpulse.service;

import com.aysimasavas.smartstore.entity.Order;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.insightpulse.common.Constants;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;

public class ProductEventService {

    private final WebClient webClient;
    private static ProductEventService instance;

    public static ProductEventService getInstance() {
        if(instance==null)
            instance=new ProductEventService(WebClient.builder().build());
        return instance;
    }

    public ProductEventService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void productViewed(Product product){

        HashMap<String, Object> params= new HashMap<>();
        params.put("providerId", Constants.PROVIDER_ID);
        params.put("clientId", Constants.CLIENT_ID);
        params.put("type", "VIEW");
        params.put("name", "product-viewed");
        params.put("status", "SUCCESS");
        params.put("product", product);


        webClient.post()
                .uri(Constants.BASE_URL + "event/product")
                .bodyValue(params)
                .retrieve()
                .toBodilessEntity()
                .block();

    }
}
