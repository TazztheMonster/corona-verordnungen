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

    public static Optional<Dataset> getDatasetByProvince(String province) {
        Optional<PersistentDataSet> optionalPersistentDataSet = datasetRepository.findByProvince(province);
        Optional<Dataset> optionalDataset = Optional.empty();
        if (optionalPersistentDataSet.isPresent()) {
            Dataset dataset = new Dataset();
            BeanUtils.copyProperties(optionalPersistentDataSet.get(), dataset);
            optionalDataset = Optional.of(dataset);
        }
        return optionalDataset;
    }

    public static List<BuildingType> getAllBuildingTypes() {
        List<PersistentBuildingType> buildingTypeList = buildingTypeRepository.getAll();
        return buildingTypeList.stream().map(e -> buildingTypefromPersistentBuildingType(e)).collect(Collectors.toList());
    }

    private static BuildingType buildingTypefromPersistentBuildingType(PersistentBuildingType persistentBuildingType) {
        BuildingType buildingType = new BuildingType();
        BeanUtils.copyProperties(persistentBuildingType, buildingType);
        return buildingType;
    }

    public static boolean updateProvince(Dataset dataSet) {

        Optional<PersistentDataSet> persistentDataSet = datasetRepository.findByProvince(dataSet.getProvince().getName());
        if (persistentDataSet.isPresent()) {
            BeanUtils.copyProperties(dataSet, persistentDataSet);
            return true;
        } else {
            return false;
        }

    }


}
