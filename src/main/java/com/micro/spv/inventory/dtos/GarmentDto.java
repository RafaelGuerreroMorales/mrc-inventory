package com.micro.spv.inventory.dtos;

import java.io.Serializable;
import java.util.List;

import com.micro.spv.inventory.enumerators.GarmentTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GarmentDto implements Serializable{
    short idGarment;
    GarmentTypeEnum garmentType;
    String garmentName;
    String description;
    List<GarmentComplementDto> garmentComplements;
}
