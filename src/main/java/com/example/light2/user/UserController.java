package com.example.light2.user;

import com.example.light2.user.details.AdminDetails;
import com.example.light2.user.details.ParticipantDetails;
import com.example.light2.user.details.PrincipalDetails;
import com.example.light2.user.details.RoleDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    SomeUser create(@RequestBody Request request) {
        return userService.create(request);
    }

//    @PutMapping("{id}")
//    RoleDetails addDetails(@PathVariable long id, @RequestBody RoleDetails roleDetails) {
//        return userService.addDetails(id, roleDetails);
//    }

    @PutMapping("participants/{id}")
    ParticipantDetails addParticipantDetails(@PathVariable long id, @RequestBody ParticipantDetails roleDetails) {
        return (ParticipantDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }

    @PutMapping("admins/{id}")
    AdminDetails addAdminDetails(@PathVariable long id, @RequestBody AdminDetails roleDetails) {
        return (AdminDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }

    @PutMapping("principals/{id}")
    PrincipalDetails addParticipantDetails(@PathVariable long id, @RequestBody PrincipalDetails roleDetails) {
        return (PrincipalDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }
}
