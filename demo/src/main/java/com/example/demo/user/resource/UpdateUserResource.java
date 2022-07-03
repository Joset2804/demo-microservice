package com.example.demo.user.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateUserResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String firstName;
}
