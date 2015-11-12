package com.epam.spring.aspect;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.List;

/**
 * Created by Daria_Tomilova on 08-Nov-15.
 */
@Aspect
public class LuckyWinnerAspect {

    private boolean isUserLucky(User user) {
        boolean isLucky = false;
        if (Math.random()*100 > 50) {
            isLucky = true;
        }
        return isLucky;
    }

    @Before("execution(* com.epam.spring.service.BookingService.getTicketPrice(..)) && args(event, seat, user)")
    public void checkLuckyUser(Event event, Integer seat, User user) {
        if (isUserLucky(user)) {
            List<Event> events = user.getLuckyEvents();
            events.add(event);
            user.setLuckyEvents(events);
            System.out.println("!!!for user " + ((User) user).getName() + " " + ((Event) event).getName() + " is lucky event");
        } else {
            System.out.println("!!!this user is loser!");
        }
    }

}
