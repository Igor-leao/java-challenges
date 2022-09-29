package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM Company AS co " +
            "INNER JOIN Candidate AS c " +
            "ON c.company_id = co.id " +
            "INNER JOIN Acceleration AS a " +
            "ON c.acceleration_id = a.id " +
            "WHERE a.id  = :accelerationId " +
            "GROUP BY a.id", nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM Company AS co " +
            "INNER JOIN Candidate AS c " +
            "ON c.company_id = co.id " +
            "INNER JOIN users AS u " +
            "ON u.id = c.user_id " +
            "WHERE u.id  = :userId ", nativeQuery = true)
    List<Company> findByUserId(Long userId);
}
