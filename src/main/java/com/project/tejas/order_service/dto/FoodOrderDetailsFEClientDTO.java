package com.project.tejas.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrderDetailsFEClientDTO {
    private List<MenuItemDTO> menuItemList;
    private Integer userId;
    private RestaurantListingDTO restaurant;
}
