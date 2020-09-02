package com.f73.corona.backend.export.controller;

import com.f73.corona.backend.export.models.BuildingType;
import com.f73.corona.backend.export.models.Dataset;
import com.f73.corona.backend.export.models.Province;
import com.f73.corona.backend.export.persistence.BuildingTypeRepository;
import com.f73.corona.backend.export.persistence.DatasetRepository;
import com.f73.corona.backend.export.persistence.PersistentBuildingType;
import com.f73.corona.backend.export.persistence.PersistentDataSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class DataController {

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private BuildingTypeRepository buildingTypeRepository;

    public Optional<Dataset> getDatasetByProvince(Province province) {

        Optional<PersistentDataSet> optionalPersistentDataSet = datasetRepository.findByProvince(province);
        Optional<Dataset> optionalDataset = Optional.empty();
        if (optionalPersistentDataSet.isPresent()) {
            Dataset dataset = new Dataset();
            BeanUtils.copyProperties(optionalPersistentDataSet.get(), dataset);
            optionalDataset = Optional.of(dataset);
        }
        return optionalDataset;
    }

    public List<BuildingType> getAllBuildingTypes() {
        List<PersistentBuildingType> buildingTypeList = buildingTypeRepository.getAll();
        for (PersistentBuildingType persistentBuildingType : buildingTypeList) {
            log.info(persistentBuildingType.toString());
        }
        return buildingTypeList.stream().map(e -> buildingTypefromPersistentBuildingType(e)).collect(Collectors.toList());
    }

    private BuildingType buildingTypefromPersistentBuildingType(PersistentBuildingType persistentBuildingType) {
        BuildingType buildingType = new BuildingType();
        BeanUtils.copyProperties(persistentBuildingType, buildingType);
        return buildingType;
    }


}
