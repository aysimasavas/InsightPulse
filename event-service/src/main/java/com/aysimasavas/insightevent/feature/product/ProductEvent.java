package com.aysimasavas.insightevent.feature.product;

import com.aysimasavas.insightevent.data.base.Event;
import com.aysimasavas.insightevent.data.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "ProductEvent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEvent extends Event {
    private ProductDto product;
}