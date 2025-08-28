package com.project.tejas.order_service.repo;

import com.project.tejas.order_service.entity.FoodOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<FoodOrder, Integer> {
}
