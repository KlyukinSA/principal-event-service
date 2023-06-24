package com.example.light2.contract;

import com.example.light2.user.SomeUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private SomeUser admin;
    private String message;
    private boolean isAccepted;
}
