package com.example.light2;

import com.example.light2.contract.Contract;
import com.example.light2.contract.ContractRepository;
import com.example.light2.contract.ContractService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ContractServiceTests {
    @Mock
    private ContractRepository contractRepository;
    @InjectMocks
    private ContractService contractService;

    @Test
    public void accept_shouldReturnAccepted_whenGivenNotAccepted() {
        Contract contract = Contract.builder().isAccepted(false).build();
        contractService.accept(contract.getId());
        assertThat(contract.isAccepted());
    }
}
