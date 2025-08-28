package com.project.tejas.order_service.entity;

import com.project.tejas.order_service.dto.MenuItemDTO;
import com.project.tejas.order_service.dto.RestaurantListingDTO;
import com.project.tejas.order_service.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class FoodOrder {
    private Integer orderId;
    private List<MenuItemDTO> menuItemList;
    private RestaurantListingDTO restaurant;
    private UserDetailsDTO userDetailsDTO;
}
