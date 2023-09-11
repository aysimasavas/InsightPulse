package com.aysimasavas.insightevent.feature.order;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Hidden
public interface OrderEventRepository extends MongoRepository<OrderEvent, String> {

}
