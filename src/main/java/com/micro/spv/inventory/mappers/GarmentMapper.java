package com.micro.spv.inventory.mappers;

import org.springframework.stereotype.Component;

import com.micro.spv.inventory.dtos.GarmentComplementDto;
import com.micro.spv.inventory.dtos.GarmentDto;
import com.micro.spv.inventory.entities.GarmentComplementaryEntity;
import com.micro.spv.inventory.entities.GarmentComplementaryGroupEntity;
import com.micro.spv.inventory.entities.GarmentEntity;
import com.micro.spv.inventory.entities.GarmentGroupEntity;
import com.micro.spv.inventory.enumerators.GarmentTypeEnum;

@Component
public class GarmentMapper {
    
    public GarmentDto toDto(GarmentEntity entity){
        return new GarmentDto(entity.getIdentityGarment(), GarmentTypeEnum.GARMENT_TYPE,
            entity.getGarmentName(), entity.getDescription(), null);
    }

     public GarmentDto toDto(GarmentGroupEntity entity){
        return new GarmentDto(entity.getIdentityGroupGarment(), GarmentTypeEnum.GARMENT_GROUP_TYPE,
            entity.getGroupGarmentName(), entity.getDescription(), null);
    }

    public GarmentComplementDto toDto(GarmentComplementaryEntity entity){
        return new GarmentComplementDto(entity.getIdentityComplementaryGarment(),
             entity.getComplementaryName(), entity.getDescription());
    }

    public GarmentComplementDto toDto(GarmentComplementaryGroupEntity entity){
        return new GarmentComplementDto(entity.getIdentityComplementaryGroupGarment(),
             entity.getComplementaryName(), entity.getDescription());
    }

}
