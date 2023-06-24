package com.example.light2.contract;

import com.example.light2.user.SomeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findByAdmin(SomeUser admin);
}
