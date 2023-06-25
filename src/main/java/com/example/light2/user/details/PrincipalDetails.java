package com.example.light2.user.details;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PrincipalDetails extends RoleDetails {
    private long taxpayerIdentificationNumber;
}
