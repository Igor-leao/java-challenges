package com.challenge.service.interfaces;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String accName) {
        return this.userRepository.findByAccelerationName(accName);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return this.userRepository.findByCompanyId(companyId);
    }
}
