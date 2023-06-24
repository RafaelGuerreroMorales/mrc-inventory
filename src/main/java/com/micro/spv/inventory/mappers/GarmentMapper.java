package com.micro.spv.inventory.mappers;

import org.springframework.stereotype.Component;

import com.micro.spv.inventory.dtos.GarmentComplementDto;
import com.micro.spv.inventory.dtos.GarmentDto;
import com.micro.spv.inventory.entities.GarmentComplementaryEntity;
import com.micro.spv.inventory.entities.GarmentEntity;

@Component
public class GarmentMapper {
    
    public GarmentDto toDto(GarmentEntity entity){
        return new GarmentDto(entity.getIdentityGarment(), entity.getGarmentName(), 
            entity.getDescription());
    }

    public GarmentComplementDto toDto(GarmentComplementaryEntity entity){
        return new GarmentComplementDto(entity.getIdentityComplementaryGarment(),
             entity.getComplementaryName(), entity.getDescription(), entity.getPrice());
    }
}
