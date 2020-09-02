package com.f73.corona.backend.imp0rt.persistence;


import com.f73.corona.backend.imp0rt.models.Province;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DatasetRepository extends CrudRepository<PersistentDataSet, String> {

    Optional<PersistentDataSet> findFirstByProvince(Province province);

}
