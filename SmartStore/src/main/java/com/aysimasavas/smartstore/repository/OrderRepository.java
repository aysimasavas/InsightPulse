package com.aysimasavas.smartstore.repository;

import com.aysimasavas.smartstore.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {

}
