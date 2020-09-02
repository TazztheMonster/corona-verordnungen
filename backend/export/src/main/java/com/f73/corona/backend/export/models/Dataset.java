package com.f73.corona.backend.export.models;

import com.f73.corona.backend.export.persistence.PersistentBuildingType;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
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
    private String other;
    private List<BuildingType> closedBuildingTypesList;


    public Dataset () {
        closedBuildingTypesList = new ArrayList<>();
    }

    public void addClosedBuildingType(BuildingType pcbt) {
        closedBuildingTypesList.add(pcbt);
    }

}
