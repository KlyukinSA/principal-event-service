package com.example.light2.user.details;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ParticipantDetails extends RoleDetails {
    private int age;
    private String pcrTestUrl;
}
