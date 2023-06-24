package com.example.light2.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SomeUser, Long> {
    SomeUser findByUsername(String username);
}
