package com.micro.spv.inventory.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GarmentComplementDto implements Serializable {
    short idGarmentComplement;
    String complementName;
    String description;
}
