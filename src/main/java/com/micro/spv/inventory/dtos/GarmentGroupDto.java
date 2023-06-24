package com.micro.spv.inventory.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GarmentGroupDto implements Serializable {
    short idGarmentGroup;
    String garmentGroupName;
    String description;
}
