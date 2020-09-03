package com.f73.corona.backend.export.persistence;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Data
@Entity
@Table(name = "buildingTypes")
public class PersistentBuildingType implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "buildingType")
    private String buildingType;
}
