package com.example.demo.user.service;

import com.example.demo.shared.exception.ResourceNotFoundException;
import com.example.demo.user.domain.model.entity.User;
import com.example.demo.user.domain.persistence.UserRepository;
import com.example.demo.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static String ENTITY = "User";
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User request) {
        return userRepository.save(request);
    }

    @Override
    public User update(Long userId, User request) {
        return userRepository.findById(userId).map(user ->
                userRepository.save(user.withFirstName(request.getFirstName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }
}
