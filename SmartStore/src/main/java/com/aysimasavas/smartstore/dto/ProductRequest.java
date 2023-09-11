package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String categoryId;
    private Integer likeCount;
    private Integer dislikeCount;
    private Boolean hasCampaign;
    private BigDecimal campaignPrice;
    private String campaignId;

    public Product mapToProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .categoryId(categoryId)
                .likeCount(likeCount)
                .dislikeCount(dislikeCount)
                .hasCampaign(hasCampaign)
                .campaignPrice(campaignPrice)
                .campaignId(campaignId)
                .build();
    }
}