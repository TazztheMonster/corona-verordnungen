package com.f73.corona.backend.export.models;

import lombok.Data;
import java.util.List;

@Data
public class Dataset {

    private Province province;
    private int personsIndoor;
    private int personsOutdoor;
    private int householdsIndoor;
    private int householdsOutdoor;
    private boolean maskMandatory;
    private double personsPsmOutdoor;
    private double personsPsmIndoor;
    private String other;
    private List<BuildingType> closedBuildingTypes;



}
