package com.example.demo.user.mapping;

import com.example.demo.shared.mapping.EnhancedModelMapper;
import com.example.demo.user.domain.model.entity.User;
import com.example.demo.user.resource.CreateUserResource;
import com.example.demo.user.resource.UpdateUserResource;
import com.example.demo.user.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public UserResource toResource(User model)
    {
        return mapper.map(model, UserResource.class);
    }

    public List<UserResource> toResource(List<User> model)
    {
        return mapper.mapList(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource)
    {
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource)
    {
        return mapper.map(resource, User.class);
    }
}
