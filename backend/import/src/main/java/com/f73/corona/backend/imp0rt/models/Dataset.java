package com.f73.corona.backend.imp0rt.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Dataset {

    private Province province;
    private int personsIndoor;
    private int personsOutdoor;
    private int householdsIndoor;
    private int householdsOutdoor;
    private boolean maskMandatory;
    private double personsPsmOutdoor;
    private double personsPsmIndoor;
    private List<BuildingType> closedBuildingTypes;

}
