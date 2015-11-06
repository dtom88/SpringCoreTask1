package com.epam.spring.service;

import com.epam.spring.DAO.EventDAO;
import com.epam.spring.entity.Auditorium;
import com.epam.spring.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class EventService {

    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void createEvent(Integer id, String name, LocalDate date, String time, Integer price, Integer capacity) {
        Event newEvent = new Event(id, name, date, time, price, capacity);
        eventDAO.add(newEvent);
    }

    public void removeEvent(Event event) {
        eventDAO.remove(event);
    }

    public Event getEventByName(String name) {
        List<Event> events = eventDAO.getAll();
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getAllEvent() {
       return  eventDAO.getAll();
    }

    public Collection<Event> getForDateRange(LocalDate from, LocalDate to) {
        List<Event> events = eventDAO.getAll();
        for(Event event : events) {
            if(event.getDate().isAfter(to) && event.getDate().isBefore(from)) {
                events.remove(event);
            }
        }
        return  events;
    }

    public List<Event> getNextEvents(LocalDate to) {
        List<Event> events = eventDAO.getAll();
        for(Event event : events) {
            if(event.getDate().isBefore(to)) {
               events.remove(event);
            }
        }
        return events;
    }

}
