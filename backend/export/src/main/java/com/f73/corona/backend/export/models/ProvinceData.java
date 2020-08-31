package com.f73.corona.backend.export.models;

import java.util.Map;
import java.util.Optional;

public class ProvinceData {

    private static Map<Province, Dataset> dataMap;


    public static Optional<Dataset> getProvinceDataByString (String searchedProvince){
        Optional<Dataset> dataset = Optional.empty();
        for (Province province : Province.values()) {
            if (province.toString().toLowerCase().equals(searchedProvince.toLowerCase())) {
                dataset = Optional.of(dataMap.get(province));
                break;
            }
        }
        return dataset;
    }



}
