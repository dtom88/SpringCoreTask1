package com.epam.spring.DAO;

import com.epam.spring.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class EventDAO {

    private Event event1;
    private Event event2;

    private List<Event> events;

    public EventDAO(Event event1, Event event2) {
        events = new ArrayList<Event>();
        this.event1 = event1;
        this.event2 = event2;
        events.add(event1);
        events.add(event2);
    }

    public Event getEvent1() {
        return event1;
    }

    public Event getEvent2() {
        return event2;
    }

    public void setEvent1(Event event1) {
        this.event1 = event1;
    }

    public void setEvent2(Event event2) {
        this.event2 = event2;
    }

    public void add(Event event) {
        events.add(event);
    }

    public void remove(Event event) {
        events.remove(event);
    }

    public List<Event> getAll() {
        return events;
    }

    public void update(Event event) {
        events.get(event.getId() - 1).setName(event.getName());
        events.get(event.getId() - 1).setDate(event.getDate());
        events.get(event.getId() - 1).setBasePrice(event.getBasePrice());
        events.get(event.getId() - 1).setTime(event.getTime());
        events.get(event.getId() - 1).setCapacity(event.getCapacity());
    }

}
