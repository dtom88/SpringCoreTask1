package com.epam.spring.aspect;

import com.epam.spring.entity.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Daria_Tomilova on 11/6/2015.
 */
public class CounterAspect {
    private Map<Event, Integer> accessByNameCounter;
    private Map<Event, Integer> queryOfPriceCounter;
    private Map<Event, Integer> bookingCounter;

    public CounterAspect() {
        accessByNameCounter = new HashMap<Event, Integer>();
        queryOfPriceCounter = new HashMap<Event, Integer>();
        bookingCounter = new HashMap<Event, Integer>();
    }

    public void countEventByName(Object retVal) {
        if (retVal != null) {
            if (!accessByNameCounter.containsKey(retVal)) {
                accessByNameCounter.put((Event) retVal, 1);
            }
            accessByNameCounter.put((Event) retVal, accessByNameCounter.get(retVal) + 1);
        }
    }

    public void countEventPrices(Object retVal) {
        if (retVal != null) {
            if (!queryOfPriceCounter.containsKey(retVal)) {
                queryOfPriceCounter.put((Event) retVal, 1);
            }
            queryOfPriceCounter.put((Event) retVal, accessByNameCounter.get(retVal) + 1);
        }
    }

    public void countTicketsBooking(Object retVal) {
        if (retVal != null) {
            if (!bookingCounter.containsKey(retVal)) {
                bookingCounter.put((Event) retVal, 1);
            }
            bookingCounter.put((Event) retVal, accessByNameCounter.get(retVal) + 1);
        }
    }


}
