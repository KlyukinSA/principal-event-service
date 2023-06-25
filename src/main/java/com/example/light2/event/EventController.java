package com.example.light2.event;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    @PreAuthorize("HasRole('ADMIN')")
    Event create(@RequestBody EventRequest eventRequest) {
        return eventService.create(eventRequest);
    }

    @PostMapping("{id}")
    @PreAuthorize("HasRole('PARTICIPANT')")
    public boolean signUp(@PathVariable long id, @RequestBody long participantId) {
        return eventService.signUp(id, participantId);
    }

    @PutMapping("{id}")
    @PreAuthorize("HasRole('ADMIN')")
    public boolean acceptParticipant(@PathVariable long id, @RequestBody long participantId) {
        return eventService.acceptParticipant(id, participantId);
    }

    @GetMapping("{id}")
    @PreAuthorize("HasRole('PARTICIPANT')")
    public boolean checkAccepted(@PathVariable long id, @RequestBody long participantId) {
        return eventService.checkAccepted(id, participantId);
    }

    @PutMapping("{id}")
    @PreAuthorize("HasRole('ADMIN')")
    public boolean confirmParticipantPayment(@PathVariable long id, @RequestBody long participantId) {
        return eventService.confirmParticipantPayment(id, participantId);
    }

    @GetMapping
    Iterable<Event> findAll() {
        return eventService.findAll();
    }
}
