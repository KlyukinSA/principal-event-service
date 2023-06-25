package com.example.light2.user;

import com.example.light2.user.details.AdminDetails;
import com.example.light2.user.details.ParticipantDetails;
import com.example.light2.user.details.PrincipalDetails;
import com.example.light2.user.details.RoleDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("participants/{id}")
    @PreAuthorize("HasRole('PARTICIPANT')")
    ParticipantDetails addParticipantDetails(@PathVariable long id, @RequestBody ParticipantDetails roleDetails) {
        return (ParticipantDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }

    @PutMapping("admins/{id}")
    @PreAuthorize("HasRole('ADMIN')")
    AdminDetails addAdminDetails(@PathVariable long id, @RequestBody AdminDetails roleDetails) {
        return (AdminDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }

    @PutMapping("principals/{id}")
    @PreAuthorize("HasRole('PRINCIPAL')")
    PrincipalDetails addPrincipalDetails(@PathVariable long id, @RequestBody PrincipalDetails roleDetails) {
        return (PrincipalDetails) userService.addDetails(id, (RoleDetails) roleDetails);
    }
}
