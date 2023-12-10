package ru.dstu.bookapp.dtos.auth;

import lombok.Data;

@Data
public class LoginUserDto {
    private String username;
    private String password;
}
