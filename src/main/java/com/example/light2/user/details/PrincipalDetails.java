package com.example.light2.user.details;

import jakarta.persistence.Embeddable;

@Embeddable
public class PrincipalDetails extends RoleDetails {
    private long taxpayerIdentificationNumber;
}
