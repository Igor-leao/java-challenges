package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    @Query(value = "SELECT * FROM Candidate AS ca " +
            "INNER JOIN Company AS co " +
            "ON ca.company_id = co.id " +
            "WHERE co.id = :companyId ", nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT * FROM Candidate AS ca " +
            "INNER JOIN Acceleration AS a " +
            "ON ca.acceleration_id = a.id " +
            "WHERE a.id = :accelerationId ", nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
