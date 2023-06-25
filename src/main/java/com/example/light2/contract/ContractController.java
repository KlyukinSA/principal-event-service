package com.example.light2.contract;

import com.example.light2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping
    @PreAuthorize("HasRole(ADMIN)") // Authentication::getId -> adminId of contractRequest
    Contract create(@RequestBody ContractRequest contractRequest) {
        return contractService.create(contractRequest);
    }

    @PutMapping("{id}")
    @PreAuthorize("HasRole(PRINCIPAL)")
    Contract accept(@PathVariable long id) {
        return contractService.accept(id);
    }
}