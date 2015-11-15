package com.epam.spring.service;

import com.epam.spring.DAO.EventDAO;
import com.epam.spring.DAO.TicketDAO;
import com.epam.spring.DAO.UserDAO;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import com.epam.spring.entity.User;

import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class BookingService {
    private TicketDAO ticketDAO;
    private UserDAO userDAO;
    private EventDAO eventDAO;
    private DiscountService discountService;

    public BookingService(TicketDAO ticketDAO, UserDAO userDAO, DiscountService discountService) {
        this.ticketDAO = ticketDAO;
        this.userDAO = userDAO;
        this.discountService = discountService;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        return ticketDAO.getAll(event);
    }

    public Double getTicketPrice(Event event, User user) {
        Integer price = event.getBasePrice();
        return price*(1 - discountService.getDiscount(user, event));
    }

    public void bookTicket(User user, Ticket ticket) {
        if (ticket.getUserId() == null) {
            ticket.setIsSold(true);
            ticket.setUserId(user.getId());
            ticket.setSellPrice(getTicketPrice(eventDAO.getEventById(ticket.getEventId()), user));
            ticketDAO.update(ticket);
            user.setPaidTickets(user.getPaidTickets() + 1);
            userDAO.update(user);
        }
    }

}
