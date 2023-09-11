package com.aysimasavas.smartstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(value = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private String id;
    private String customerId;
    private List<Product> products;
    private BigDecimal rawTotalPrice;
    private Boolean hasCampaign;
    private List<Campaign> appliedCampaigns;
    private BigDecimal totalCampaignedPrice;
}
