package com.aysimasavas.insightevent.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoDto {
    private String name;
    private BigDecimal percent;
}
