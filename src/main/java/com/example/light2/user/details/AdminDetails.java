package com.example.light2.user.details;

import jakarta.persistence.Embeddable;

@Embeddable
public class AdminDetails extends RoleDetails {
    private String orgName;
}
