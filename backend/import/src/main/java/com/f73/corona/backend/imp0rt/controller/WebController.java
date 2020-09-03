package com.f73.corona.backend.imp0rt.controller;

import com.f73.corona.backend.imp0rt.models.BuildingType;
import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.models.Province;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins="*")
@RestController
@Slf4j
public class WebController {

    @Autowired
    private DataController dataController;

    @PutMapping("/province")
    public ResponseEntity updateProvinceData(@RequestBody Dataset dataset) {
        log.info(dataset.toString());
        boolean somethingHappen = false;
        boolean updateSuccessful = dataController.updateProvince(dataset);
        if (updateSuccessful) {
            somethingHappen = true;
        }
        if (somethingHappen) {
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/buildingType")
    public Object addBuildingType(@RequestBody String newBuildingType) {
        boolean buildingTypeAddet = dataController.addBuildingType(newBuildingType);
        if (buildingTypeAddet) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}