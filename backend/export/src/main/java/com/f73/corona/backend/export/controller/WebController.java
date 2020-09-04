package com.f73.corona.backend.export.controller;

import com.f73.corona.backend.export.models.BuildingType;
import com.f73.corona.backend.export.models.Dataset;
import com.f73.corona.backend.export.models.Province;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@CrossOrigin(origins="*")
@RestController
public class WebController {

    @Autowired
    DataController dataController;

    @GetMapping("/province/{province}")
    public Object getProvinceData(@PathVariable String province) {
        Optional<Dataset> dataset = dataController.getDatasetByProvince(Province.valueOf(province));
        log.info(dataset.toString());
        if (dataset.isPresent()) {
            return new ResponseEntity<Dataset>(dataset.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/provinces")
    public List<String> getProvinces() {
        return Stream.of(Province.values()).map(Province::name).collect(Collectors.toList());
    }

    @GetMapping("/buildingTypes")
    public List<BuildingType> getAllBuildingTypes() {
        return dataController.getAllBuildingTypes();
    }

}