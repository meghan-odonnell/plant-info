package com.techelevator.service;

import com.techelevator.model.Plant;
import com.techelevator.model.PlantDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestPlantAPIService implements PlantAPIService{

    @Value("${API_KEY}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://perenual.com/api/species";


    @Override
    public List<Plant> getPlants() {
        return null;
    }

    @Override
    public PlantDetail getPlantDetailByID(int id) {
        return null;
    }
}
