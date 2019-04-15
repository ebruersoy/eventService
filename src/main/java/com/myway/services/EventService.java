package com.myway.services;

import com.myway.dto.EventRequest;
import com.myway.entity.Event;
import com.myway.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author Ebru Göksal
 */
@Component
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findByUuid(UUID uuid) {
        return eventRepository.findByEmployeeUuidOrderByEventDateAsc(uuid);
    }

    public void save(EventRequest foundEmployee) {
        Event event = new Event();
        event.setEventDate(foundEmployee.getEventDate());
        event.setTopic(foundEmployee.getTopic());
        event.setEmployeeUuid(foundEmployee.getEmployeeUuid());
        event.setEmployeeJson(foundEmployee.getEmployeeJson());
        eventRepository.save(event);
    }
}
