package com.f73.corona.backend.imp0rt.persistence;

import com.f73.corona.backend.imp0rt.models.Province;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "dataset")
public class PersistentDataSet implements Serializable {

    @Id
    @GeneratedValue
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
    @JoinTable(name = "closedBuildingTypes",
            joinColumns = {
                    @JoinColumn(name = "dataset", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "buildingTypes", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<PersistentBuildingType> closedBuildingTypes;

}
