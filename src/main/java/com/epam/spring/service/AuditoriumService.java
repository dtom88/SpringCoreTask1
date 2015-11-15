package com.epam.spring.service;

import com.epam.spring.DAO.AuditoriumDAO;
import com.epam.spring.DAO.EventDAO;
import com.epam.spring.DAO.TicketDAO;
import com.epam.spring.entity.Auditorium;
import com.epam.spring.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class AuditoriumService {

    private AuditoriumDAO auditoriumDAO;
    private EventDAO eventDAO;
    private TicketDAO ticketDAO;

    public AuditoriumService(AuditoriumDAO auditoriumDAO, EventDAO eventDAO) {
        this.auditoriumDAO = auditoriumDAO;
        this.eventDAO = eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriumDAO.getAll();
    }

    public Integer getSeatsNumber(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getNumbersOfSeats();
    }

    public boolean assignAuditorium(Event event, Auditorium auditorium) {
        if (!auditorium.getCalendar().contains(event.getDate()) && auditorium.getNumbersOfSeats() >= event.getCapacity()) {
            List<Date> calendar = auditorium.getCalendar();
            calendar.add(event.getDate());
            auditoriumDAO.updateCalendar(event,auditorium);
            auditorium.setCalendar(calendar);
            auditoriumDAO.update(auditorium);
            event.setAuditoriumId(auditorium.getId());
            eventDAO.update(event);
            ticketDAO.createTicketsForEvent(event);
            return true;
        }
        return false;
    }

    public Auditorium getAuditoriumByName(String name) {
        return auditoriumDAO.getAuditoriumByName(name);
    }

    public Auditorium getAuditoriumById(Integer id) {
        return auditoriumDAO.getAuditoriumById(id);
    }
}
