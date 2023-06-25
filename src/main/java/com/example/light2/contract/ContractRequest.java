package com.example.light2.contract;

import com.example.light2.user.SomeUser;
import lombok.Data;

@Data
public class ContractRequest {
    private long adminId;
    private String message;
}
