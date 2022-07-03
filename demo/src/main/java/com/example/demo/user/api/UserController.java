package com.example.demo.user.api;

import com.example.demo.user.domain.service.UserService;
import com.example.demo.user.mapping.UserMapper;
import com.example.demo.user.resource.CreateUserResource;
import com.example.demo.user.resource.UpdateUserResource;
import com.example.demo.user.resource.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping
    public List<UserResource> getAllUsers()
    {
        return mapper.toResource(userService.getAll());
    }

    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource request)
    {
        return mapper.toResource(userService.create(mapper.toModel(request)));
    }

    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource request)
    {
        return mapper.toResource(userService.update(userId, mapper.toModel(request)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
        return userService.delete(userId);
    }
}
