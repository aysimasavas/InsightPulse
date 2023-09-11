package com.aysimasavas.smartstore.repository;

import com.aysimasavas.smartstore.entity.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign,String> {
}
