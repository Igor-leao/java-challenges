package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "SELECT MAX(sub.score) FROM Submission AS sub " +
            "WHERE sub.challenge_id = :challengeId ", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "SELECT * FROM Submission AS sub " +
            "INNER JOIN Challenge AS ch ON ch.id = sub.challenge_id " +
            "INNER JOIN Acceleration AS a ON a.challenge_id = ch.id " +
            "WHERE a.id = :accelerationId AND ch.id = :challengeId ", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
