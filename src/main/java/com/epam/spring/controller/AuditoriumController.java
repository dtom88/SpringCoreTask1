package com.epam.spring.controller;

import com.epam.spring.entity.Auditorium;
import com.epam.spring.entity.Event;
import com.epam.spring.service.AuditoriumService;
import com.epam.spring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darya on 13-Feb-16.
 */
@RequestMapping("/auditoriums")
@Controller
public class AuditoriumController {

    @Autowired
    AuditoriumService auditoriumService;
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/{audId}/events/{eventId}", method = RequestMethod.PUT)
    public Boolean assignAuditorium(@PathVariable Integer eventId, @PathVariable Integer audId) {
        Event event = eventService.getEventById(eventId);
        Auditorium auditorium = auditoriumService.getAuditoriumById(audId);
        if (event == null || auditorium == null) {
            return false;
        }
        return auditoriumService.assignAuditorium(event, auditorium);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Auditorium getAuditoriumByName(@PathVariable String name) {
        return auditoriumService.getAuditoriumByName(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Auditorium getAuditoriumById(@PathVariable Integer id) {
        return auditoriumService.getAuditoriumById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auditorium> getAll() {
        return auditoriumService.getAll();
    }
}
