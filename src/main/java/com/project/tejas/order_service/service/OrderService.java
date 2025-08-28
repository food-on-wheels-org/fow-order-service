package com.project.tejas.order_service.service;

import com.project.tejas.order_service.dto.FoodOrderDTO;
import com.project.tejas.order_service.dto.FoodOrderDetailsFEClientDTO;
import com.project.tejas.order_service.dto.UserDetailsDTO;
import com.project.tejas.order_service.entity.FoodOrder;
import com.project.tejas.order_service.mapper.FoodOrderMapper;
import com.project.tejas.order_service.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public FoodOrderDTO saveFoodOrderInDb(FoodOrderDetailsFEClientDTO feFoodOrderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDetailsDTO userDetailsDTO = fetchUserDetailsFromUserId(feFoodOrderDetails.getUserId());

        FoodOrder orderToSave = new FoodOrder(newOrderId, feFoodOrderDetails.getMenuItemList(), feFoodOrderDetails.getRestaurant(), userDetailsDTO);
        orderRepo.save(orderToSave);
        return FoodOrderMapper.INSTANCE.mapFoodOrdertoFoodOrderDTO(orderToSave);
    }

    private UserDetailsDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/userinfo/fetchUser/" + userId, UserDetailsDTO.class);
    }
}
