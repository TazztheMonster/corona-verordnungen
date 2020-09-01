package com.f73.corona.backend.export.controller;

import com.f73.corona.backend.export.models.BuildingType;
import com.f73.corona.backend.export.models.Dataset;
import com.f73.corona.backend.export.persistence.BuildingTypeRepository;
import com.f73.corona.backend.export.persistence.DatasetRepository;
import com.f73.corona.backend.export.persistence.PersistentBuildingType;
import com.f73.corona.backend.export.persistence.PersistentDataSet;
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


}
