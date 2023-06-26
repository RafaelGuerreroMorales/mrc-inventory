package com.micro.spv.inventory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.spv.inventory.dtos.GarmentComplementDto;
import com.micro.spv.inventory.dtos.GarmentDto;
import com.micro.spv.inventory.entities.GarmentComplementaryGroupEntity;
import com.micro.spv.inventory.entities.GarmentGroupEntity;
import com.micro.spv.inventory.mappers.GarmentMapper;
import com.micro.spv.inventory.repositories.GarmentGroupRepository;

@Service
public class GarmentGroupService {

    @Autowired
    GarmentMapper garmentMapper;

    @Autowired 
    GarmentGroupRepository garmentGroupRepository;

    public List<GarmentDto> searchGarmentGruopByService(short idService){
        List<GarmentDto> garmentGruopList = new ArrayList<>();
        List<Short> idGarmentGroupsList = garmentGroupRepository.findGarmentGroupPrice(idService)
            .stream().map(item -> item.getIdentityGarmentGroup()).toList();

        if(idGarmentGroupsList.isEmpty())
            return new ArrayList<>();
        for(GarmentGroupEntity item : garmentGroupRepository.findAllGarmentGroupBy(idGarmentGroupsList)){
            List<GarmentComplementDto> garmentcomplement = new ArrayList<>();
            var garmentGroupDto =  garmentMapper.toDto(item);

            for(GarmentComplementaryGroupEntity itemComplement : garmentGroupRepository.findComplementaryGroupByIdentityGroup(item.getIdentityGroupGarment())){
                garmentcomplement.add(garmentMapper.toDto(itemComplement));
            }
            
            garmentGroupDto.setGarmentComplements(garmentcomplement);
            garmentGruopList.add(garmentGroupDto);
        }

        return garmentGruopList;
    }
    
}
