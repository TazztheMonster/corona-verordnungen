package com.f73.corona.backend.imp0rt.controller;

import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@Slf4j
public class DataController {

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private BuildingTypeRepository buildingTypeRepository;

    public boolean updateProvince(Dataset dataSet) {

        log.info(dataSet.toString());

        if (dataSet.getClosedBuildingTypes() == null) {
            dataSet.setClosedBuildingTypes(new ArrayList<>());
        }
        Optional<PersistentDataSet> persistentDataSet = datasetRepository.findFirstByProvince(dataSet.getProvince());
        if (persistentDataSet.isPresent()) {
            BeanUtils.copyProperties(dataSet, persistentDataSet.get());
            datasetRepository.save(persistentDataSet.get());
            return true;
        } else {
            if (dataSet.getProvince() != null) {
                PersistentDataSet pds = Converter.convertToPersistentDataSet(dataSet);
                datasetRepository.save(pds);
                return true;
            }
            return false;
        }

    }


    public boolean addBuildingType(String newBuildingType) {
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
