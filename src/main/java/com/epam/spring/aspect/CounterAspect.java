package com.epam.spring.aspect;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Daria_Tomilova on 11/6/2015.
 */
@Aspect
public class CounterAspect {
    private Map<Event, Integer> accessByNameCounter;
    private Map<Event, Integer> queryOfPriceCounter;
    private Map<Event, Integer> bookingCounter;

    public CounterAspect() {
        accessByNameCounter = new HashMap<Event, Integer>();
        queryOfPriceCounter = new HashMap<Event, Integer>();
        bookingCounter = new HashMap<Event, Integer>();
    }

    @AfterReturning(pointcut="execution(* com.epam.spring.service.EventService.getEventByName(..))",  returning="retVal")
    public void countEventByName(Object retVal) {
        if (retVal != null) {
            if (!accessByNameCounter.containsKey(retVal)) {
                accessByNameCounter.put((Event) retVal, 1);
            }
            accessByNameCounter.put((Event) retVal, accessByNameCounter.get(retVal) + 1);
        }
    }

    @AfterReturning(pointcut = "execution(* com.epam.spring.service.BookingService.getTicketPrice(..)) &&args(event,..)")
    public void countEventPrices(Object event) {
        if (event != null) {
            if (!queryOfPriceCounter.containsKey(event)) {
                queryOfPriceCounter.put((Event) event, 1);
            }
            queryOfPriceCounter.put((Event) event, accessByNameCounter.get(event) + 1);
        }
    }

    @AfterReturning(pointcut = "execution(* com.epam.spring.service.BookingService.bookTicket(..)) && args(user, ticket)")
    public void countTicketsBooking(Object user, Object ticket) {
        if(ticket != null) {
            Ticket tic = (Ticket) ticket;
            if (!bookingCounter.containsKey(tic.getEvent())) {
                bookingCounter.put(tic.getEvent(), 1);
            }
            bookingCounter.put(tic.getEvent(), accessByNameCounter.get(tic.getEvent()) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Event event : accessByNameCounter.keySet()) {
            sb.append(event.getName()).append(" was searched by name ").append(accessByNameCounter.get(event)).append(" times, ");
            if (queryOfPriceCounter.containsKey(event))
            sb.append("this event prise was quaried ").append(queryOfPriceCounter.get(event)).append(" times, ");
            if (bookingCounter.containsKey(event))
            sb.append("this event tickets were booked ").append(bookingCounter.get(event)).append(" times.");
        }
        return sb.toString();
    }


}
