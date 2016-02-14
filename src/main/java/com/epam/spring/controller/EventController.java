package com.epam.spring.controller;

import com.epam.spring.entity.Event;
import com.epam.spring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by Darya on 13-Feb-16.
 */
@RequestMapping("/events")
@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.POST)
    public void createEvent(@RequestParam String name, @RequestParam Date date,
                            @RequestParam Integer price, @RequestParam Integer capacity) {
        eventService.createEvent(name, date, price, capacity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeEvent(Event event) {
        eventService.removeEvent(event);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Event getEventByName(@PathVariable String name) {
        return eventService.getEventByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getForDateRange(@RequestParam Date from, @RequestParam Date to) {
        return eventService.getForDateRange(from, to);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getNextEvents(@RequestParam Date from) {
        return eventService.getNextEvents(from);
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable Integer eventId) {
        return eventService.getEventById(eventId);
    }
}
