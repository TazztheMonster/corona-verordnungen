package com.f73.corona.backend.export.persistence;


import org.springframework.data.repository.CrudRepository;

public interface DatasetRepository extends CrudRepository<PersistentDataSet, String> {

    PersistentDataSet findByProvince(String province);

}
