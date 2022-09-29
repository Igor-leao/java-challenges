package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{UserId}/{AccelerationId}/{CompanyId}")
    public Optional<Candidate> findById(
            @PathVariable("UserId") Long userId,
            @PathVariable("AccelerationId") Long accelerationId,
            @PathVariable("CompanyId") Long companyId
    ) {
        return this.candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping
    public List<Candidate> findByCompanyId(@RequestParam Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }
}
