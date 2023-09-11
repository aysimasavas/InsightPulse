package com.aysimasavas.smartstore.service;

import com.aysimasavas.smartstore.dto.CampaignRequest;
import com.aysimasavas.smartstore.dto.CampaignResponse;

import com.aysimasavas.smartstore.entity.Campaign;

import com.aysimasavas.smartstore.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public CampaignResponse createCampaign(CampaignRequest resquest){
        Campaign campaign=resquest.mapToCampaign();
        Campaign savedCampaign=campaignRepository.save(campaign);
        return CampaignResponse.mapCampaign(savedCampaign);
    }

    public List<CampaignResponse> getAllCampaigns(){
        List<Campaign> categories=campaignRepository.findAll();
        return categories.stream().map(CampaignResponse::mapCampaign).toList();
    }

    public CampaignResponse getCampaignById(String id){
        Optional<Campaign> campaign=campaignRepository.findById(id);
        return CampaignResponse.mapCampaign(campaign.get());
    }
}
