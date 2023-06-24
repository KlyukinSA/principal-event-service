package com.example.light2.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private String username;
    private String password;
    private Role role;
}
