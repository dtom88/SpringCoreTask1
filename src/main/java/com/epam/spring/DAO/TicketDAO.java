package com.epam.spring.DAO;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class TicketDAO {

    @Autowired
    private Ticket ticket1;
    @Autowired
    private Ticket ticket2;
    @Autowired
    private Ticket ticket3;
    @Autowired
    private Ticket ticket4;
    @Autowired
    private Ticket ticket5;
    @Autowired
    private Ticket ticket6;
    @Autowired
    private Ticket ticket7;
    @Autowired
    private Ticket ticket8;
    @Autowired
    private Ticket ticket9;
    @Autowired
    private Ticket ticket10;
    @Autowired
    private Event event1;

    List<Ticket> tickets;

    Map<Event, List<Ticket>> ticketsForEvent;

    public TicketDAO(Ticket ticket1, Ticket ticket2, Ticket ticket3, Ticket ticket4, Ticket ticket5, Ticket ticket6, Ticket ticket7, Ticket ticket8, Ticket ticket9, Ticket ticket10, Event event) {
        tickets = new ArrayList<Ticket>();
        this.ticket1 = ticket1;
        this.ticket2 = ticket2;
        this.ticket3 = ticket3;
        this.ticket4 = ticket4;
        this.ticket5 = ticket5;
        this.ticket6 = ticket6;
        this.ticket7 = ticket7;
        this.ticket8 = ticket8;
        this.ticket9 = ticket9;
        this.ticket10 = ticket10;
        this.event1 = event;
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);
        ticketsForEvent = new HashMap<Event, List<Ticket>>();
        ticketsForEvent.put(event1, tickets);
    }

    public Ticket getTicket1() {
        return ticket1;
    }

    public Ticket getTicket2() {
        return ticket2;
    }

    public Ticket getTicket3() {
        return ticket3;
    }

    public Ticket getTicket4() {
        return ticket4;
    }

    public Ticket getTicket5() {
        return ticket5;
    }

    public Ticket getTicket6() {
        return ticket6;
    }

    public Ticket getTicket7() {
        return ticket7;
    }

    public Ticket getTicket8() {
        return ticket8;
    }

    public Ticket getTicket9() {
        return ticket9;
    }

    public Ticket getTicket10() {
        return ticket10;
    }

    public Event getEvent1() {
        return event1;
    }

    public void setTicket1(Ticket ticket1) {
        this.ticket1 = ticket1;
    }

    public void setTicket2(Ticket ticket2) {
        this.ticket2 = ticket2;
    }

    public void setTicket3(Ticket ticket3) {
        this.ticket3 = ticket3;
    }

    public void setTicket4(Ticket ticket4) {
        this.ticket4 = ticket4;
    }

    public void setTicket5(Ticket ticket5) {
        this.ticket5 = ticket5;
    }

    public void setTicket6(Ticket ticket6) {
        this.ticket6 = ticket6;
    }

    public void setTicket7(Ticket ticket7) {
        this.ticket7 = ticket7;
    }

    public void setTicket8(Ticket ticket8) {
        this.ticket8 = ticket8;
    }

    public void setTicket9(Ticket ticket9) {
        this.ticket9 = ticket9;
    }

    public void setTicket10(Ticket ticket10) {
        this.ticket10 = ticket10;
    }

    public void setEvent1(Event event1) {
        this.event1 = event1;
    }

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public void remove(Ticket ticket) {
        tickets.remove(ticket);
    }

    public void update(Ticket ticket) {
        tickets.get(ticket.getSeat()-1).setUser(ticket.getUser());
    }

    public List<Ticket> getAll(Event event) {
        return ticketsForEvent.get(event);
    }

}
