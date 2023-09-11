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
public class CampaignResponse {


    private String id;
    private String name;
    private BigDecimal percent;

    public static CampaignResponse mapCampaign(Campaign campaign){
        return CampaignResponse.builder().id(campaign.getId())
                .name(campaign.getName())
                .percent(campaign.getPercent())
                .build();
    }
}
