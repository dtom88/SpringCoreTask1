package com.epam.spring.aspect;

import com.epam.spring.aspectDAO.CounterAspectDAO;
import com.epam.spring.entity.CounterLog;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import com.epam.spring.entity.User;
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

//    @Override
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        for (Integer eventId : accessByNameCounter.keySet()) {
//            sb.append(eventService.getEventById(eventId).getName()).append(" was searched by name ").append(
//                    accessByNameCounter.get(eventId)).append(" times, ");
//            if (queryOfPriceCounter.containsKey(eventId))
//            sb.append("this event prise was quaried ").append(queryOfPriceCounter.get(eventId)).append(" times, ");
//            if (bookingCounter.containsKey(eventId))
//            sb.append("this event tickets were booked ").append(bookingCounter.get(eventId)).append(" times.");
//        }
//        return sb.toString();
//    }


}
