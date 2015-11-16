package com.epam.spring.aspect;

import com.epam.spring.aspectDAO.CounterAspectDAO;
import com.epam.spring.entity.*;
import com.epam.spring.service.EventService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daria_Tomilova on 11/6/2015.
 */
@Aspect
public class CounterAspect {
    private CounterAspectDAO counterAspectDAO;

    public CounterAspect(CounterAspectDAO counterAspectDAO) {
        this.counterAspectDAO = counterAspectDAO;
    }

    public void setCounterAspectDAO(CounterAspectDAO counterAspectDAO) {
        this.counterAspectDAO = counterAspectDAO;
    }

    @After("execution(* com.epam.spring.service.EventService.getEventByName(..))")
    public void countEventByName() {
        if (!counterAspectDAO.getAllMetodNames().contains("getEventByName")) {
            counterAspectDAO.add(new CounterLog("getEventByName", 1));
        } else {
            counterAspectDAO.update("getEventByName");
        }
    }

    @After("execution(* com.epam.spring.service.BookingService.getTicketPrice(..))")
    public void countEventPrices() {
            if (!counterAspectDAO.getAllMetodNames().contains("getTicketPrice")) {
                counterAspectDAO.add(new CounterLog("getTicketPrice", 1));
            } else {
                counterAspectDAO.update("getTicketPrice");
            }
    }

    @After("execution(* com.epam.spring.service.BookingService.bookTicket(..))")
    public void countTicketsBooking() {
            if (!counterAspectDAO.getAllMetodNames().contains("bookTicket")) {
                counterAspectDAO.add(new CounterLog("bookTicket", 1));
            } else {
                counterAspectDAO.update("bookTicket");
            }
    }

}
