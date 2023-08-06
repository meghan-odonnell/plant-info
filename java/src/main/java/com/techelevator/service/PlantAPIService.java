package com.techelevator.service;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;

import java.util.List;

public interface PlantAPIService {

    List<Plant> getPlants();

    PlantDetail getPlantDetailByID(int id);


}
