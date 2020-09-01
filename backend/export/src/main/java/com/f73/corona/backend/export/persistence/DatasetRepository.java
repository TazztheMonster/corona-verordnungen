package com.f73.corona.backend.export.persistence;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DatasetRepository extends CrudRepository<PersistentDataSet, String> {

    Optional<PersistentDataSet> findByProvince(String province);

}
