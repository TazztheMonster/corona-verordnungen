package com.f73.corona.backend.imp0rt.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "buildingTypes")
public class PersistentBuildingType implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "buildingType")
    private String buildingType;
}
