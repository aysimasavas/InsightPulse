package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Campaign;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignRequest {

    private String name;
    private BigDecimal percent;

    public Campaign mapToCampaign(){
        return Campaign.builder().name(name)
                .percent(percent)
                .build();
    }
}
