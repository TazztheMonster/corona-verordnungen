package com.f73.corona.backend.imp0rt.persistence;

import com.f73.corona.backend.imp0rt.models.BuildingType;
import com.f73.corona.backend.imp0rt.models.Dataset;

import java.util.*;

public class Converter {

    public static PersistentDataSet convertToPersistentDataSet(Dataset dataset) {
        PersistentDataSet persistentDataSet = new PersistentDataSet();
        persistentDataSet.setOther(dataset.getOther());
        persistentDataSet.setProvince(dataset.getProvince());
        persistentDataSet.setMaskMandatory(dataset.isMaskMandatory());
        persistentDataSet.setPersonsIndoor(dataset.getPersonsIndoor());
        persistentDataSet.setPersonsOutdoor(dataset.getPersonsOutdoor());
        persistentDataSet.setHouseholdsIndoor(dataset.getHouseholdsIndoor());
        persistentDataSet.setPersonsPsmIndoor(dataset.getPersonsPsmIndoor());
        persistentDataSet.setHouseholdsOutdoor(dataset.getHouseholdsOutdoor());
        persistentDataSet.setPersonsPsmOutdoor(dataset.getPersonsPsmOutdoor());
        persistentDataSet.setClosedBuildingTypes(convertToPersistentBuildingTypes(dataset.getClosedBuildingTypes()));
        return persistentDataSet;
    }

    public static PersistentBuildingType convertToPersistentBuildingType(BuildingType buildingType) {
        PersistentBuildingType persistentBuildingType = new PersistentBuildingType();
        persistentBuildingType.setBuildingType(buildingType.getBuildingType());
        persistentBuildingType.setId(buildingType.getId());
        return persistentBuildingType;
    }

    public static List<PersistentBuildingType> convertToPersistentBuildingTypes(List<BuildingType> buildingTypeList) {
        List<PersistentBuildingType> persistentBuildingTypeList = new ArrayList<>();
        for (BuildingType buildingType : buildingTypeList) {
            persistentBuildingTypeList.add(convertToPersistentBuildingType(buildingType));
        }
        return persistentBuildingTypeList;
    }

}
