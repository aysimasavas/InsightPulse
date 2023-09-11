package com.aysimasavas.insightevent.feature.order;

import com.aysimasavas.insightevent.data.base.Event;
import com.aysimasavas.insightevent.data.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "OrderEvent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEvent extends Event {

    private String orderId;

    private List<ProductDto> products;

    private Double orderPrice;

    private Boolean hasDiscount;

    private Double discountedPrice;


}