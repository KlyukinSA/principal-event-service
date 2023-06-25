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

    public SomeUser create(UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()) != null) {
            return null;
        }
        return userRepository.save(SomeUser.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build()
        );
    }

    public RoleDetails addDetails(String username, RoleDetails roleDetails) {
        var user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        switch (user.getRole()) {
            case PARTICIPANT -> user.setRoleDetails((ParticipantDetails) roleDetails);
            case ADMIN -> user.setRoleDetails((AdminDetails) roleDetails);
            case PRINCIPAL -> user.setRoleDetails((PrincipalDetails) roleDetails);
        }
        userRepository.save(user);
        return user.getRoleDetails();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
