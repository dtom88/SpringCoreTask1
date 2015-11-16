package com.epam.spring.aspect;

import com.epam.spring.entity.*;
import com.epam.spring.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.List;

/**
 * Created by Daria_Tomilova on 08-Nov-15.
 */
@Aspect
public class LuckyWinnerAspect {

    private boolean isUserLucky() {
        boolean isLucky = false;
        if (Math.random()*100 > 50) {
            isLucky = true;
        }
        return isLucky;
    }

    @Before("execution(* com.epam.spring.service.BookingService.getTicketPrice(..)) && args(event,.., user)")
    public void checkLuckyUser(Event event, User user) {
        if (isUserLucky()) {
            List<Event> events = user.getLuckyEvents();
            events.add(event);
            user.setLuckyEvents(events);
            System.out.println("!!!for user " + user.getName() + " " + event.getName() + " is lucky event");
        } else {
            System.out.println("!!!this user is loser!");
        }
    }

}
