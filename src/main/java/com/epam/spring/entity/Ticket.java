package com.epam.spring.entity;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Ticket {
    private Event event;
    private Integer seat;
    private User user;

    public Ticket(Event event, Integer seat, User user) {
        this.event = event;
        this.seat = seat;
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
