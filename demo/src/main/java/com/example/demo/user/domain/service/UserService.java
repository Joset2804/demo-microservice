package com.example.demo.user.domain.service;

import com.example.demo.user.domain.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User request);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);

}
