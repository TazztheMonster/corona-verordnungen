package com.f73.corona.backend.export.persistence;

import com.f73.corona.backend.export.models.BuildingType;
import com.f73.corona.backend.export.models.Province;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@Entity
@Table(name = "provinces")
public class PersistentDataSet {
    @Id
    private int id;
    @Enumerated
    @Column(name = "province")
    private Province province;
    private int personsIndoor;
    private int personsOutdoor;
    private int householdsIndoor;
    private int householdsOutdoor;
    private boolean maskMandatory;
    private double personsPsmOutdoor;
    private double personsPsmIndoor;
    private String other;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "buildingTypes",
            joinColumns = {
                    @JoinColumn(name = "province", referencedColumnName = "province",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "buildingTypes", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<PersistentBuildingType> closedBuildingTypesList;


    public PersistentDataSet () {
        closedBuildingTypesList = new ArrayList<>();
    }

    public void addClosedBuildingType(PersistentBuildingType pcbt) {
        closedBuildingTypesList.add(pcbt);
    }

}
