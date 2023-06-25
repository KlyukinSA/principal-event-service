package com.example.light2;

import com.example.light2.contract.Contract;
import com.example.light2.contract.ContractRepository;
import com.example.light2.contract.ContractRequest;
import com.example.light2.contract.ContractService;
import com.example.light2.user.SomeUser;
import com.example.light2.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Repeat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContractServiceTests {
    @Mock
    private ContractRepository contractRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ContractService contractService;

    @Test
    public void accept_shouldReturnAccepted_whenGivenNotAccepted() {
        Contract contract = Contract.builder().isAccepted(false).build();
        contractService.accept(contract.getId());
        assertThat(contract.isAccepted());
    }
}
