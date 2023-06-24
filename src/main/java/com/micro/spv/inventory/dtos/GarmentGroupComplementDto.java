package com.micro.spv.inventory.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GarmentGroupComplementDto implements Serializable {
    short idGarmentGroupComplement;
    String GarmentGroupComplementName;
    String description;
    float price;
}
