package org.example.apitestingwitherrorthrowing.Dtos;

import lombok.Data;

@Data
public class UserResponse {

    private String name;
    private String email;
    private String token;
}
