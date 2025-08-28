package com.project.tejas.order_service.controller;

import com.project.tejas.order_service.dto.FoodOrderDTO;
import com.project.tejas.order_service.dto.FoodOrderDetailsFEClientDTO;
import com.project.tejas.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderServiceController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveFoodOrder")
    public ResponseEntity<FoodOrderDTO> saveFoodOrder(@RequestBody FoodOrderDetailsFEClientDTO feFoodOrderDetails){
        FoodOrderDTO savedOrder = orderService.saveFoodOrderInDb(feFoodOrderDetails);
        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }
}
