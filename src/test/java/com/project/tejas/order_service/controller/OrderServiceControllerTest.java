package com.project.tejas.order_service.controller;

import com.project.tejas.order_service.dto.*;
import com.project.tejas.order_service.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceControllerTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderServiceController orderServiceController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFoodOrder(){
        List<MenuItemDTO> mockMenuItemList = Arrays.asList(
                new MenuItemDTO(1, "dish 1", "Desc 1", true, 123L, 10, 1),
                new MenuItemDTO(2, "dish 2", "desc 2", false, 234L, 20, 2)
        );
        Integer mockUserId = 1;
        RestaurantListingDTO mockRestaurant = new RestaurantListingDTO(1, "Restaurant 1", "Address 1", "city 1", "desc 1");
        UserDetailsDTO mockUserDTO = new UserDetailsDTO(1, "username1", "password1", "Address 1", "city 1");
        FoodOrderDetailsFEClientDTO mockFEclientDTO = new FoodOrderDetailsFEClientDTO(mockMenuItemList, mockUserId, mockRestaurant);
        FoodOrderDTO mockFoodOrder = new FoodOrderDTO(1, mockMenuItemList, mockRestaurant, mockUserDTO);
        when(orderService.saveFoodOrderInDb(mockFEclientDTO)).thenReturn(mockFoodOrder);

        ResponseEntity<FoodOrderDTO> response = orderServiceController.saveFoodOrder(mockFEclientDTO);

        assertEquals(mockFoodOrder, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(orderService, times(1)).saveFoodOrderInDb(mockFEclientDTO);
    }

}
