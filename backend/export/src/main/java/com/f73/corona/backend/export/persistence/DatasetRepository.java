package com.f73.corona.backend.export.persistence;


import com.f73.corona.backend.export.models.Province;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DatasetRepository extends CrudRepository<PersistentDataSet, String> {

    Optional<PersistentDataSet> findFirstByProvince(Province province);

}
