package com.micro.spv.inventory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.spv.inventory.dtos.GarmentComplementDto;
import com.micro.spv.inventory.dtos.GarmentDto;
import com.micro.spv.inventory.entities.GarmentComplementaryEntity;
import com.micro.spv.inventory.entities.GarmentEntity;
import com.micro.spv.inventory.mappers.GarmentMapper;
import com.micro.spv.inventory.repositories.GarmentRepository;

@Service
public class GarmentService {
    @Autowired 
    GarmentRepository garmentRepository;

    @Autowired
    GarmentMapper garmentMapper;

    public List<GarmentDto> searchGarmentByService(short identityService){
        List<GarmentDto> garmentList = new ArrayList<>();
        var idGarmentList = garmentRepository.findGarmentPriceByIdentityService(identityService).stream()
            .map(item -> item.getIdentityGarment()).toList();

        if(idGarmentList.isEmpty())
            return new ArrayList<>();

        for(GarmentEntity item : garmentRepository.findGarmentByIds(idGarmentList)) {
            List<GarmentComplementDto> garmentComplentary = new ArrayList<>();
            var garmentDto =garmentMapper.toDto(item);

            for(GarmentComplementaryEntity itemComplement : garmentRepository.findGarmentComplementaryByIdCategory(item.getIdentityCategoryGarment()))
                garmentComplentary.add(garmentMapper.toDto(itemComplement));
            
            garmentDto.setGarmentComplements(garmentComplentary);
            garmentList.add(garmentDto);
        }
        return garmentList;
    }
}
