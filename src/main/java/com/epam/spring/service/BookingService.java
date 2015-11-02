package com.epam.spring.service;

import com.epam.spring.DAO.TicketDAO;
import com.epam.spring.DAO.UserDAO;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import com.epam.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class BookingService {
    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DiscountService discountService;

    public BookingService(TicketDAO ticketDAO, UserDAO userDAO, DiscountService discountService) {
        this.ticketDAO = ticketDAO;
        this.userDAO = userDAO;
        this.discountService = discountService;
    }

    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public DiscountService getDiscountService() {
        return discountService;
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

    public Double getTicketPrice(Event event, Integer seat, User user) {
        List<Ticket> tickets =  ticketDAO.getAll(event);
        Double price = Double.valueOf(tickets.get(seat - 1).getEvent().getBasePrice());
        price *= (1 - discountService.getDiscount(user, event));
        return price;
    }

    public void bookTicket(User user, Ticket ticket) {
        List<Ticket> tickets = ticketDAO.getAll(ticket.getEvent());
        tickets.get(tickets.indexOf(ticket)).setUser(user);
        ticketDAO.update(ticket);
        user.setPaidTickets(user.getPaidTickets() + 1);
        userDAO.update(user);
    }

    public List<Ticket> getTiketsForEvent(Event event) {
        return ticketDAO.getAll(event);
    }
}
