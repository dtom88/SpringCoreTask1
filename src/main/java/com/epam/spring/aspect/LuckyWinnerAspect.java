package com.epam.spring.aspect;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

/**
 * Created by Daria_Tomilova on 08-Nov-15.
 */
public class LuckyWinnerAspect {

    private boolean isUserLucky(User user) {
        boolean isLucky = false;
        if (Math.random()*100 > 50) {
            isLucky = true;
        }
        return isLucky;
    }

    public void checkLuckyUser(Object event, Object user) {
        if (isUserLucky((User) user)) {
            User us = (User) user;
            List<Event> events = us.getLuckyEvents();
            events.add((Event) event);
            us.setLuckyEvents(events);
        }
    }
}
