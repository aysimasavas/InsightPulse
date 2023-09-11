package com.aysimasavas.smartstore.repository;

import com.aysimasavas.smartstore.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.sound.sampled.Port;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> getProductByCategoryId(String categoryId);
    Product getProductById(String id);

}
