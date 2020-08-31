package com.f73.corona.backend.export.controller;

import com.f73.corona.backend.export.models.Dataset;
import com.f73.corona.backend.export.models.Province;
import com.f73.corona.backend.export.models.ProvinceData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class webController {

    @RequestMapping("/province/{province}")
    public Object getProvinceData(@PathVariable String province) {

        Optional<Dataset> dataset = ProvinceData.getProvinceDataByString(province);

        if (dataset.isPresent()) {
            return dataset.get();
        } else {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/province")
    public List<String> getProvinces() {
        return Stream.of(Province.values()).map(Province::name).collect(Collectors.toList());
    }



}
