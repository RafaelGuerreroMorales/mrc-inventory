package com.micro.spv.inventory.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.spv.inventory.dtos.GarmentDto;
import com.micro.spv.inventory.dtos.ResponseDto;
import com.micro.spv.inventory.services.GarmentGroupService;

@RestController
@RequestMapping("garment/groups")
public class GarmentGroupController {

    @Autowired
    GarmentGroupService garmentGroupService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    @ResponseBody
    public ResponseDto<ArrayList<GarmentDto>> getGarmentGroupByService(@RequestParam("idservice") short idService){
        try {
            ArrayList<GarmentDto> garmentGroupList = new ArrayList<>(); 
            garmentGroupList.addAll(garmentGroupService.searchGarmentGruopByService(idService));
            return new ResponseDto<>((short) 0, "Oks", garmentGroupList);
        } catch (Exception ex) {
            logger.error("Ups ocurrio una exepcion", ex);
        }
        return new ResponseDto<>((short) -1, "Ups Ocurrio un problema", null);  
    }
    
}
