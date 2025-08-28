package com.project.tejas.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderDTO {
    private Integer orderId;
    private List<MenuItemDTO> menuItemList;
    private RestaurantListingDTO restaurant;
    private UserDetailsDTO userDetailsDTO;
}
