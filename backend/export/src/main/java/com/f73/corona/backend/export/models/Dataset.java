package com.f73.corona.backend.export.models;

import com.f73.corona.backend.export.persistence.PersistentBuildingType;
import com.f73.corona.backend.export.persistence.PersistentDataSet;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
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
    private List<BuildingType> closedBuildingTypesList = new ArrayList<>();

    public void addClosedBuildingType(BuildingType pcbt) {
        closedBuildingTypesList.add(pcbt);
    }

    public Dataset(PersistentDataSet dataset) {
        this.province = dataset.getProvince();
        this.personsIndoor = dataset.getPersonsIndoor();
        this.personsOutdoor = dataset.getPersonsOutdoor();
        this.householdsIndoor = dataset.getHouseholdsIndoor();
        this.householdsOutdoor = dataset.getHouseholdsOutdoor();
        this.maskMandatory = dataset.isMaskMandatory();
        this.personsPsmOutdoor = dataset.getPersonsPsmOutdoor();
        this.personsPsmIndoor = dataset.getPersonsPsmIndoor();

    }

}
