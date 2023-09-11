package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Campaign;
import com.aysimasavas.smartstore.entity.Order;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private String id;
    private String customerId;
    private List<Product> products;
    private BigDecimal rawTotalPrice;
    private Boolean hasCampaign;
    private List<Campaign> appliedCampaigns;
    private BigDecimal totalCampaignedPrice;

    public static OrderResponse mapToOrder(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .products(order.getProducts())
                .rawTotalPrice(order.getRawTotalPrice())
                .hasCampaign(order.getHasCampaign())
                .appliedCampaigns(order.getAppliedCampaigns())
                .totalCampaignedPrice(order.getTotalCampaignedPrice())
                .build();
    }

}
