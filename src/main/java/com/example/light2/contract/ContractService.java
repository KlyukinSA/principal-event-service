package com.example.light2.contract;

import com.example.light2.user.Role;
import com.example.light2.user.UserRepository;
import com.example.light2.user.details.AdminDetails;
import liquibase.ui.UIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final UserRepository adminRepository;

    Contract create(ContractRequest contractRequest) {
        var optionalAdmin = adminRepository.findById(contractRequest.getAdminId());
        if (optionalAdmin.isEmpty()) { // || optionalAdmin.get().getRole() != Role.ADMIN
            return null;
        }
        System.out.println(((AdminDetails) optionalAdmin.get().getRoleDetails()).getOrgName());
        return contractRepository.save(Contract.builder()
                .admin(optionalAdmin.get())
                .message(contractRequest.getMessage())
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
