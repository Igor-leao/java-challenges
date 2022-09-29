package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query(value = "SELECT * FROM Challenge AS ch " +
            "INNER JOIN Acceleration AS ac ON ac.challenge_id = ch.id " +
            "INNER JOIN Candidate AS ca ON ca.acceleration_id = ac.id " +
            "WHERE ca.user_id = :userId AND ca.acceleration_id = :accelerationId ", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
