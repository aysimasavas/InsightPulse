package com.aysimasavas.insightevent.feature.product;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;

@Hidden
public interface ProductEventRepository extends MongoRepository<ProductEvent, String> {
}
