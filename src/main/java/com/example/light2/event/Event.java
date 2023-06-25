package com.example.light2.event;

import com.example.light2.user.SomeUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int cost;
    @OneToOne
    private SomeUser admin;
    @OneToMany
    private List<SomeUser> participants;
}
