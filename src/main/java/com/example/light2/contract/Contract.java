package com.example.light2.contract;

import com.example.light2.user.SomeUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private SomeUser admin;
    private String message;
    private boolean isAccepted;
}
