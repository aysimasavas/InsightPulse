package com.aysimasavas.smartstore.repository;

import com.aysimasavas.smartstore.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
