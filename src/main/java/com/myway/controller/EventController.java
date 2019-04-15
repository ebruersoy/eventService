package com.myway.controller;

import com.myway.entity.Event;
import com.myway.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * @author Ebru Göksal
 */
@Controller
@RequestMapping(path = "event/v1")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "{uuid}")
    public @ResponseBody
    List<Event> findByUuid(@PathVariable("uuid") UUID uuid){
        return  eventService.findByUuid(uuid);
    }

}
