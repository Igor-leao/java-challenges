package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM users AS u " +
            "INNER JOIN Candidate AS c " +
            "ON c.user_id = u.id " +
            "INNER JOIN Acceleration AS a " +
            "ON a.id = c.acceleration_id " +
            "WHERE a.name like %:accName% ",
    nativeQuery = true)
    List<User> findByAccelerationName(@Param("accName") String accName);

    @Query(value = "SELECT * FROM users AS u " +
            "INNER JOIN Candidate AS c " +
            "ON c.user_id = u.id " +
            "INNER JOIN Company AS co " +
            "ON co.id = c.company_id " +
            "WHERE co.id = :companyID ",
            nativeQuery = true)
    List<User> findByCompanyId(@Param("companyID") Long companyId);
}
