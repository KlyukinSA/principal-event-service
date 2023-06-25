package com.example.light2.user;

import com.example.light2.user.details.AdminDetails;
import com.example.light2.user.details.ParticipantDetails;
import com.example.light2.user.details.PrincipalDetails;
import com.example.light2.user.details.RoleDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public SomeUser create(Request request) {
//        System.out.println("try register" + request.getUsername());
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return null;
        }
        return userRepository.save(SomeUser.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .role(request.getRole())
                        .build()
        );
    }

    RoleDetails addDetails(long userId, RoleDetails roleDetails) {
        var optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }
        var user = optionalUser.get();
        switch (user.getRole()) {
            case PARTICIPANT -> user.setRoleDetails((ParticipantDetails) roleDetails);
            case ADMIN -> user.setRoleDetails((AdminDetails) roleDetails);
            case PRINCIPAL -> user.setRoleDetails((PrincipalDetails) roleDetails);
        }
//        user.setRoleDetails(roleDetails);
        userRepository.save(user);
        return user.getRoleDetails();
    }

//    AdminDetails addAdminDetails(long userId, AdminDetails roleDetails) {
//        return
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}