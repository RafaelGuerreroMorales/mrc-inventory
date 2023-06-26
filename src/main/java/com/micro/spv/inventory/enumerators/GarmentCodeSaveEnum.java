package com.micro.spv.inventory.enumerators;

public enum GarmentCodeSaveEnum {
    GARMENT_SAVED((short) 0 ),
    GARMENT_EXISTS((short) 1);

    short value;
    GarmentCodeSaveEnum(short value){
        this.value = value;
    }

    public short getValue(){
        return this.value;
    }
}
