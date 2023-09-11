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
public class ProductResponse {

    private String id;
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

    public static ProductResponse mapProduct(Product product) {
        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .categoryId(product.getCategoryId())
                .likeCount(product.getLikeCount())
                .dislikeCount(product.getDislikeCount())
                .hasCampaign(product.getHasCampaign())
                .campaignPrice(product.getCampaignPrice())
                .campaignId(product.getCampaignId())
                .build();
    }
}