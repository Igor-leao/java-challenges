package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Long userId) {
        return this.userService.findById(userId);
    }

    @GetMapping
    public List<User> findByAccelerationNameOrCompanyId(
            @RequestParam(value = "accelerationName", required = false) String accName,
            @RequestParam(value = "companyId", required = false) Long companyId) {

        if (companyId != null)  return this.userService.findByCompanyId(companyId);

        return this.userService.findByAccelerationName(accName);

    }

}
