package com.f73.corona.backend.export.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingTypeRepository extends CrudRepository<PersistentBuildingType, Integer> {

    public List<PersistentBuildingType> getAll();

}
