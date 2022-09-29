package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    @Query(value = "SELECT * FROM Acceleration AS a " +
            "INNER JOIN Candidate AS c " +
            "ON c.acceleration_id = a.id " +
            "INNER JOIN Company AS co " +
            "ON co.id = c.company_id " +
            "WHERE co.id  = :companyId ", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
