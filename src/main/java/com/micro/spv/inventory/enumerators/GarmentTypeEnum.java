package com.micro.spv.inventory.enumerators;

public enum GarmentTypeEnum {
    GARMENT_TYPE((short) 0),
    GARMENT_GROUP_TYPE((short) 1);

    short value;
    GarmentTypeEnum(short value){
        this.value = value;
    }

    public short getValue(){
        return this.value;
    }
}
