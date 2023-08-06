package com.techelevator.controller;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;
import com.techelevator.service.PlantAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantController {

    @Autowired
    PlantAPIService service;

    @RequestMapping(path="-list?page=1&key={key}", method= RequestMethod.GET)
    public List<Plant>getAllPlants(){
        return service.getPlants();
    }

    @RequestMapping(path="/details/{id}?key={key}", method=RequestMethod.GET)
    public PlantDetail getPlantByID(@PathVariable int id, @PathVariable int key){
        return service.getPlantDetailByID(id);
    }

}
