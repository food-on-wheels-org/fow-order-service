package com.project.tejas.order_service.controller;

import com.project.tejas.order_service.dto.FoodOrderDTO;
import com.project.tejas.order_service.dto.FoodOrderDetailsFEClientDTO;
import com.project.tejas.order_service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Tag(name = "Order Service Controller", description = "Endpoints for managing food orders from customers")
public class OrderServiceController {
    @Autowired
    OrderService orderService;

    @Operation(summary = "Save a Food Order", description = "Creates a new food order entry in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order successfully saved",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FoodOrderDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/saveFoodOrder")
    public ResponseEntity<FoodOrderDTO> saveFoodOrder(@RequestBody FoodOrderDetailsFEClientDTO feFoodOrderDetails){
        FoodOrderDTO savedOrder = orderService.saveFoodOrderInDb(feFoodOrderDetails);
        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }
}
