package com.f73.corona.backend.export.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingTypeRepository extends CrudRepository<PersistentBuildingType, Integer> {

    @Query("SELECT '*' FROM PersistentBuildingType")
    public List<PersistentBuildingType> getAll();

}
