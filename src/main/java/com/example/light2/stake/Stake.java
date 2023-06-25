package com.example.light2.stake;

import com.example.light2.event.Event;
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
