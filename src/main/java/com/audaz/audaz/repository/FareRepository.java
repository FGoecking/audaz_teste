package com.audaz.audaz.repository;

import com.audaz.audaz.model.Fare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends CrudRepository<Fare, Long > {


}
