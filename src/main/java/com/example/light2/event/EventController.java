package com.example.light2.event;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    @PreAuthorize("HasRole('ADMIN')")
    Event create(@RequestBody EventRequest eventRequest, Authentication admin) {
        return eventService.create(eventRequest, admin.getName());
    }

    @PostMapping("{id}")
    @PreAuthorize("HasRole('PARTICIPANT')")
    public boolean signUp(@PathVariable long id, Authentication participant) {
        return eventService.signUp(id, participant.getName());
    }

    @PutMapping("{id}")
    @PreAuthorize("HasRole('ADMIN')")
    public boolean acceptParticipant(@PathVariable long id, @RequestBody long participantId) {
        return eventService.acceptParticipant(id, participantId);
    }

    @GetMapping("{id}")
    @PreAuthorize("HasRole('PARTICIPANT')")
    public boolean checkAccepted(@PathVariable long id, Authentication participant) {
        return eventService.checkAccepted(id, participant.getName());
    }

    @PutMapping("{id}/payment")
    @PreAuthorize("HasRole('ADMIN')")
    public boolean confirmParticipantPayment(@PathVariable long id, @RequestBody long participantId) {
        return eventService.confirmParticipantPayment(id, participantId);
    }

    @GetMapping
    Iterable<Event> findAll() {
        return eventService.findAll();
    }
}
