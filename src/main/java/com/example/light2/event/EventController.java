package com.example.light2.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    Iterable<Event> getAll() {
        return eventService.findAll();
    }

//    @PostMapping
//    void create(EventCreateRequest eventCreateRequest) {
//        eventRepository.save(Event.builder().name(eventCreateRequest))
//    }
}
