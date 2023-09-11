package com.aysimasavas.smartstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "Campaign")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campaign {

    private String id;
    private String name;
    private BigDecimal percent;

}
