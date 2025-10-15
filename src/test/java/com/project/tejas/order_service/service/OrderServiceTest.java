package com.project.tejas.order_service.service;

import com.project.tejas.order_service.dto.*;
import com.project.tejas.order_service.entity.FoodOrder;
import com.project.tejas.order_service.mapper.FoodOrderMapper;
import com.project.tejas.order_service.repo.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    OrderRepo orderRepo;

    @Mock
    SequenceGenerator sequenceGenerator;

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFoodOrderInDb(){
        Integer mockOrderId = 123;
        List<MenuItemDTO> mockMenuList = Arrays.asList(
                new MenuItemDTO(1, "dish 1", "desc 1", true, 123L, 10, 1),
                new MenuItemDTO(2, "dish 2", "desc 2", false, 234L, 20, 2)
        );
        RestaurantListingDTO mockRestaurant = new RestaurantListingDTO(1, "Restaurant 1", "address 1", "city 1", "desc 1");
        UserDetailsDTO mockUserDTO = new UserDetailsDTO(1, "username1", "password1", "address1", "city1");
        FoodOrder mockFoodOrder = new FoodOrder(mockOrderId,mockMenuList, mockRestaurant, mockUserDTO);
        FoodOrderDetailsFEClientDTO mockFEClientDTO = new FoodOrderDetailsFEClientDTO(mockMenuList, 1, mockRestaurant);
        when(sequenceGenerator.generateNextOrderId()).thenReturn(mockOrderId);
        when(restTemplate.getForObject(anyString(), eq(UserDetailsDTO.class))).thenReturn(mockUserDTO);
        when(orderRepo.save(mockFoodOrder)).thenReturn(mockFoodOrder);

        FoodOrderDTO resulyDTO = orderService.saveFoodOrderInDb(mockFEClientDTO);

        assertEquals(FoodOrderMapper.INSTANCE.mapFoodOrdertoFoodOrderDTO(mockFoodOrder), resulyDTO);
        verify(orderRepo, times(1)).save(mockFoodOrder);
    }

}
