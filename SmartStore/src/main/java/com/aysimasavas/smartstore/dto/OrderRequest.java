package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Campaign;
import com.aysimasavas.smartstore.entity.Order;
import com.aysimasavas.smartstore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String customerId;
    private List<String> productsIds;
    private BigDecimal rawTotalPrice;
    private Boolean hasCampaign;
    private List<Campaign> appliedCampaigns;
    private BigDecimal totalCampaignedPrice;

    public Order mapToOrderWithProducts(List<Product> products) {
        return Order.builder()
                .customerId(customerId)
                .products(products)
                .rawTotalPrice(rawTotalPrice)
                .hasCampaign(hasCampaign)
                .appliedCampaigns(appliedCampaigns)
                .totalCampaignedPrice(totalCampaignedPrice)
                .build();
    }
    public Order mapToOrder() {
        return Order.builder()
                .customerId(customerId)
                .rawTotalPrice(rawTotalPrice)
                .hasCampaign(hasCampaign)
                .appliedCampaigns(appliedCampaigns)
                .totalCampaignedPrice(totalCampaignedPrice)
                .build();
    }
}
