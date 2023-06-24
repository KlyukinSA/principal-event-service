package com.example.light2.user.details;

import jakarta.persistence.Embeddable;

@Embeddable
public class ParticipantDetails extends RoleDetails {
    private int age;
    private String pcrTestUrl;
}
