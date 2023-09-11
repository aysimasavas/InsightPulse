package com.aysimasavas.insightevent.feature.custom;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;

@Hidden
public interface CustomEventRepository extends MongoRepository<CustomEvent, String> {
}

