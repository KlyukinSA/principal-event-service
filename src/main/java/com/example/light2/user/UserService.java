package com.example.light2.user;

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

    SomeUser create(Request request) {
        return userRepository.save(SomeUser.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .build()
        );
    }

    SomeUser addDetails(long userId, RoleDetails roleDetails) {
        var optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }
        optionalUser.get().setRoleDetails(roleDetails);
        userRepository.save(optionalUser.get());
        return optionalUser.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
