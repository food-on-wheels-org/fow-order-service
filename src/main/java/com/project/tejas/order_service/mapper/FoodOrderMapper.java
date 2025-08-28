package com.project.tejas.order_service.mapper;

import com.project.tejas.order_service.dto.FoodOrderDTO;
import com.project.tejas.order_service.entity.FoodOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodOrderMapper {
    FoodOrderMapper INSTANCE = Mappers.getMapper(FoodOrderMapper.class);
    FoodOrder mapFoodOrderDTOToFoodOrder(FoodOrderDTO foodOrderDTO);
    FoodOrderDTO mapFoodOrdertoFoodOrderDTO (FoodOrder foodOrder);
}
