package com.f73.corona.backend.export.persistence;

import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buildingTypes")
public class PersistentBuildingType {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "buildingType")
    private String buildingType;
}
