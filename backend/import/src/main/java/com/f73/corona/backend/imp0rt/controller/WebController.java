package com.f73.corona.backend.imp0rt.controller;

import com.f73.corona.backend.imp0rt.models.BuildingType;
import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.models.Province;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class WebController {

    @PutMapping("/province")
    public Object updateProvinceData(@RequestBody List<Dataset> dataList) {



        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/provinces")
    public List<String> getProvinces() {
        return Stream.of(Province.values()).map(Province::name).collect(Collectors.toList());
    }

    @RequestMapping("/buildingTypes")
    public List<BuildingType> getAllBuildingTypes() {
        return DataController.getAllBuildingTypes();
    }

}