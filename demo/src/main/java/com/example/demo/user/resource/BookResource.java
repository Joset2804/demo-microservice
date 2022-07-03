package com.example.demo.user.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResource {
    private Long id;
    private String name;
    private UserResource user;
}
