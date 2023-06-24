package com.example.light2.event;

import com.example.light2.contract.ContractRepository;
import com.example.light2.stake.Stake;
import com.example.light2.stake.StakeRepository;
import com.example.light2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final StakeRepository stakeRepository;
    private final ContractRepository contractRepository;

    public Event create(long adminId, Request request) {
        var optionalAdmin = userRepository.findById(adminId);
        if (optionalAdmin.isEmpty()) {
            return null;
        }
        var optionalContract = contractRepository.findByAdmin(optionalAdmin.get());
        if (optionalContract.isEmpty() || !optionalContract.get().isAccepted()) {
            return null;
        }
        return eventRepository.save(Event.builder()
                .admin(optionalAdmin.get())
                .name(request.getName())
                .cost(request.getCost())
                .build());
    }

    // only for parti.
    public boolean signUp(long eventId, long participantId) {
        var optionalParticipant = userRepository.findById(participantId);
        if (optionalParticipant.isEmpty()) {
            return false;
        }
        var optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isEmpty()) {
            return false;
        }
        var optionalParticipantAttempt = stakeRepository.findByEventAndParticipant(optionalEvent.get(), optionalParticipant.get());
        if (optionalParticipantAttempt.isPresent()) {
            return false;
        }
        Stake participantAttempt = Stake.builder()
                .event(optionalEvent.get())
                .participant(optionalParticipant.get())
                .isAccepted(false)
                .isPaid(false)
                .build();
        stakeRepository.save(participantAttempt);
        return true;
    }

    public boolean acceptParticipant(long eventId, long participantId) {
        var optionalParticipant = userRepository.findById(participantId);
        var optionalEvent = eventRepository.findById(eventId);
        var optionalParticipantAttempt = stakeRepository.findByEventAndParticipant(optionalEvent.get(), optionalParticipant.get());
        if (optionalParticipantAttempt.isEmpty()) {
            return false;
        }
        Stake participantAttempt = optionalParticipantAttempt.get();
        participantAttempt.setAccepted(true);
        stakeRepository.save(participantAttempt);
        return true;
    }

    public boolean checkAccepted(long eventId, long participantId) {
        var optionalParticipant = userRepository.findById(participantId);
        var optionalEvent = eventRepository.findById(eventId);
        var optionalParticipantAttempt = stakeRepository.findByEventAndParticipant(optionalEvent.get(), optionalParticipant.get());
        return optionalParticipantAttempt.map(Stake::isAccepted).orElse(false);
    }

    public boolean confirmParticipantPayment(long eventId, long participantId) {
        var optionalParticipant = userRepository.findById(participantId);
        var optionalEvent = eventRepository.findById(eventId);
        var optionalParticipantAttempt = stakeRepository.findByEventAndParticipant(optionalEvent.get(), optionalParticipant.get());
        if (optionalParticipantAttempt.isEmpty()) {
            return false;
        }
        Stake participantAttempt = optionalParticipantAttempt.get();
        participantAttempt.setPaid(true);
        stakeRepository.save(participantAttempt);
        return true;
    }

    public Iterable<Event> findAll() {
        eventRepository.save(Event.builder().cost(155).build());
        return eventRepository.findAll();
    }
}
