package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable("id") Long companyId) {
        return  this.companyService.findById(companyId);
    }
    @GetMapping
    public List<Company> findByAccelerationIdOrUserId(
            @RequestParam(value = "accelerationId", required = false) Long accelerationId,
            @RequestParam(value = "userId", required = false) Long userId) {
        if (accelerationId != null) {
            return this.companyService.findByAccelerationId(accelerationId);
        }
        return this.companyService.findByUserId(userId);
    }
}
