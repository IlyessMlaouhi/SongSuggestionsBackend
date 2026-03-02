package org.example.apitestingwitherrorthrowing.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long  id;
    private String name;
    private String email;
    private String password;

}
