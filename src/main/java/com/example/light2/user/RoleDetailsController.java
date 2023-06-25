package com.example.light2.user;

import com.example.light2.user.details.AdminDetails;
import com.example.light2.user.details.ParticipantDetails;
import com.example.light2.user.details.PrincipalDetails;
import com.example.light2.user.details.RoleDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("role-details")
@RequiredArgsConstructor
public class RoleDetailsController {
    private final UserService userService;

    @PutMapping("participant")
    @PreAuthorize("HasRole('PARTICIPANT')")
    ParticipantDetails addParticipantDetails(@RequestBody ParticipantDetails roleDetails, Authentication authentication) {
        return (ParticipantDetails) userService.addDetails(authentication.getName(), (RoleDetails) roleDetails);
    }

    @PutMapping("admin")
    @PreAuthorize("HasRole('ADMIN')")
    AdminDetails addAdminDetails(@RequestBody AdminDetails roleDetails, Authentication authentication) {
        return (AdminDetails) userService.addDetails(authentication.getName(), (RoleDetails) roleDetails);
    }

    @PutMapping("principal")
    @PreAuthorize("HasRole('PRINCIPAL')")
    PrincipalDetails addPrincipalDetails(@RequestBody PrincipalDetails roleDetails, Authentication authentication) {
        return (PrincipalDetails) userService.addDetails(authentication.getName(), (RoleDetails) roleDetails);
    }
}
