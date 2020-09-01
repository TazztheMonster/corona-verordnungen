package com.f73.corona.backend.imp0rt.controller;

import com.f73.corona.backend.imp0rt.models.BuildingType;
import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.persistence.BuildingTypeRepository;
import com.f73.corona.backend.imp0rt.persistence.DatasetRepository;
import com.f73.corona.backend.imp0rt.persistence.PersistentBuildingType;
import com.f73.corona.backend.imp0rt.persistence.PersistentDataSet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataController {

    @Autowired
    private static DatasetRepository datasetRepository;

    @Autowired
    private static BuildingTypeRepository buildingTypeRepository;

    public static boolean updateProvince(Dataset dataSet) {
        Optional<PersistentDataSet> persistentDataSet = datasetRepository.findByProvince(dataSet.getProvince().getName());
        if (persistentDataSet.isPresent()) {
            BeanUtils.copyProperties(dataSet, persistentDataSet.get());
            datasetRepository.save(persistentDataSet.get());
            return true;
        } else {
            return false;
        }

    }


}
