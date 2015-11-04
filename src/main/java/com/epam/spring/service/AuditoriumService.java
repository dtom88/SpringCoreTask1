package com.epam.spring.service;

import com.epam.spring.DAO.AuditoriumDAO;
import com.epam.spring.DAO.EventDAO;
import com.epam.spring.entity.Auditorium;
import com.epam.spring.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class AuditoriumService {

    private AuditoriumDAO auditoriumDAO;
    private EventDAO eventDAO;

    public AuditoriumService(AuditoriumDAO auditoriumDAO, EventDAO eventDAO) {
        this.auditoriumDAO = auditoriumDAO;
        this.eventDAO = eventDAO;
    }

    public AuditoriumDAO getAuditoriumDAO() {
        return auditoriumDAO;
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

    public List<Integer> getVipSeats(String name) {
        return auditoriumDAO.getAuditoriumByName(name).getVipSeats();
    }

    public void assignAuditorium(Event event, Auditorium auditorium) {
        if (!auditorium.getCalendar().contains(event.getDate()) && auditorium.getNumbersOfSeats() >= event.getCapacity()) {
            List<LocalDate> calendar = auditorium.getCalendar();
            calendar.add(event.getDate());
            auditorium.setCalendar(calendar);
            auditoriumDAO.update(auditorium);
            event.setAuditorium(auditorium);
            eventDAO.update(event);
        }
    }

    public Auditorium getAuditoriumByName(String name) {
        List<Auditorium> auds = auditoriumDAO.getAll();
        for(Auditorium a : auds) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }
}
