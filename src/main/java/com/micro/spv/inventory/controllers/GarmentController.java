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
import com.micro.spv.inventory.services.GarmentService;

@RestController
@RequestMapping("garments")
public class GarmentController {
    @Autowired
    GarmentService garmentService;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping
    @ResponseBody
    public ResponseDto<ArrayList<GarmentDto>> getGarmentByService(@RequestParam("idservice") short idService){
     try {
            ArrayList<GarmentDto> garmentsList = new ArrayList<>();
            garmentsList.addAll(garmentService.searchGarmentByService(idService));
            return new ResponseDto<>((short) 0, "Oks", garmentsList);
        } catch (Exception ex) {
            logger.error("Ups ocurrio una exepcion", ex);
        }
        return new ResponseDto<>((short) -1, "Ups Ocurrio un problema", null);    
    }
}
