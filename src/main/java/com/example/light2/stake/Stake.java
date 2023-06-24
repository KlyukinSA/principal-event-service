package com.example.light2.stake;

import com.example.light2.event.Event;
import com.example.light2.user.SomeUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stake {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Event event;
    @OneToOne
    private SomeUser participant;
    private boolean isAccepted;
    private boolean isPaid;
}
