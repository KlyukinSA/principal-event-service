package com.example.light2.auth;

import com.example.light2.user.UserRequest;
import com.example.light2.user.SomeUser;
import com.example.light2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("register")
    SomeUser create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }
//    @PostMapping
//    SomeUser authenticate(Request request) {
//        return userService.create(request);
//    }
}
