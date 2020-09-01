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
        boolean somethingHappen = false;

        for (Dataset dataset: dataList) {
            boolean updateSuccessful = DataController.updateProvince(dataset);
            if (updateSuccessful) {
                somethingHappen = true;
            }
        }

        if (somethingHappen) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}