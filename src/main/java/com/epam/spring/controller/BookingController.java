package com.epam.spring.controller;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import com.epam.spring.entity.User;
import com.epam.spring.service.BookingService;
import com.epam.spring.service.EventService;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darya on 13-Feb-16.
 */
@RequestMapping("/tickets")
@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public List<Ticket> getTicketsForEvent(@PathVariable Integer eventId) {
        Event event = eventService.getEventById(eventId);
        if (event == null) {
            return null;
        }
        return bookingService.getTicketsForEvent(event);
    }

    @RequestMapping(value = "/price/event/{eventId}/user/{userId}", method = RequestMethod.GET)
    public Double getTicketPrice(@PathVariable Integer eventId, @PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        Event event = eventService.getEventById(eventId);
        if (user == null || event == null) {
            return null;
        }
        return bookingService.getTicketPrice(event, user);
    }

    @RequestMapping(value = "/{ticketId}/user/{userId}", method = RequestMethod.PUT)
    public void bookTicket(@PathVariable Integer userId, @PathVariable Integer ticketId) {
        User user = userService.getUserById(userId);
        Ticket ticket = bookingService.getTicketById(ticketId);
        if (user == null || ticket == null) {
            return;
        }
        bookingService.bookTicket(user, ticket);
    }
}
