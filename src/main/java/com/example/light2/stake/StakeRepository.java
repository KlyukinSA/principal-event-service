package com.example.light2.stake;

import com.example.light2.event.Event;
import com.example.light2.user.SomeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StakeRepository extends JpaRepository<Stake, Long> {
    Optional<Stake> findByEventAndParticipant(Event event, SomeUser participant);
}
