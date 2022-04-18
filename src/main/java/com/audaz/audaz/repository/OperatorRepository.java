package com.audaz.audaz.repository;

import com.audaz.audaz.model.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {

    Operator findByCode(String code);
}
