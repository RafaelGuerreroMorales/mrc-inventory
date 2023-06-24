package com.micro.spv.inventory.mappers;

import org.springframework.stereotype.Component;

import com.micro.spv.inventory.dtos.GarmentGroupDto;
import com.micro.spv.inventory.entities.GarmentGroupEntity;

@Component
public class GarmentGroupMapper {
    
    public GarmentGroupDto toDto(GarmentGroupEntity entity){
        return new GarmentGroupDto(entity.getIdentityGroupGarment(), entity.getGroupGarmentName(),
            entity.getDescription());
    }
}
