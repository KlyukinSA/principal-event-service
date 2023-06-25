package com.example.light2.user.details;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AdminDetails extends RoleDetails {
    private String orgName;
}
