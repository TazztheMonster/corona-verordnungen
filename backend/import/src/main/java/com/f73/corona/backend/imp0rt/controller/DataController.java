package com.f73.corona.backend.imp0rt.controller;

import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.persistence.BuildingTypeRepository;
import com.f73.corona.backend.imp0rt.persistence.DatasetRepository;
import com.f73.corona.backend.imp0rt.persistence.PersistentBuildingType;
import com.f73.corona.backend.imp0rt.persistence.PersistentDataSet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DataController {

    @Autowired
    private static DatasetRepository datasetRepository;

    @Autowired
    private static BuildingTypeRepository buildingTypeRepository;

    public static boolean updateProvince(Dataset dataSet) {
        Optional<PersistentDataSet> persistentDataSet = datasetRepository.findFirstByProvince(dataSet.getProvince().toString());
        if (persistentDataSet.isPresent()) {
            BeanUtils.copyProperties(dataSet, persistentDataSet.get());
            datasetRepository.save(persistentDataSet.get());
            return true;
        } else {
            return false;
        }

    }


    public static boolean addBuildingType(String newBuildingType) {
        Optional<PersistentBuildingType> buildingType = buildingTypeRepository.findFirstByBuildingType(newBuildingType);
        if(buildingType.isPresent()) {
            return false;
        } else {
            PersistentBuildingType persistentBuildingType = new PersistentBuildingType();
            persistentBuildingType.setBuildingType(newBuildingType);
            buildingTypeRepository.save(persistentBuildingType);
            return true;
        }

    }
}
