package com.example.light2.contract;

import com.example.light2.user.Role;
import com.example.light2.user.UserRepository;
import liquibase.ui.UIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final UserRepository adminRepository;

    Contract create(long adminId, String message) {
        var optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isEmpty()) { // || optionalAdmin.get().getRole() != Role.ADMIN
            return null;
        }
        return contractRepository.save(Contract.builder()
                .admin(optionalAdmin.get())
                .message(message)
                .isAccepted(false)
                .build());
    }

    Contract accept(long contractId) {
        var optionalContract = contractRepository.findById(contractId);
        if (optionalContract.isEmpty()) {
            return null;
        }
        optionalContract.get().setAccepted(true);
        return optionalContract.get();
    }
}
