package com.aysimasavas.insightevent.data.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private Double price;
    private String categoryId;
    private String categoryName;
    private Boolean hasDiscount;
    private Double discountedPrice;
    private Integer quantity;
    private String url;

}