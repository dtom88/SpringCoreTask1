package com.epam.spring;

import com.epam.spring.aspect.CounterAspect;
import com.epam.spring.aspect.DiscountAspect;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Daria_Tomilova on 01-Nov-15.
 */
public class App {
    private static App app;

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        CounterAspect cAsp = (CounterAspect) appContext.getBean("counterBean");
        DiscountAspect discAsp = (DiscountAspect) appContext.getBean("discountCounterBean");

        AuditoriumService auditoriumService = (AuditoriumService) appContext.getBean("auditoriumService");
        BookingService bookingService = (BookingService) appContext.getBean("bookingService");
        EventService eventService = (EventService) appContext.getBean("eventService");
        DiscountService discountService = (DiscountService) appContext.getBean("discountService");
        UserService userService = (UserService) appContext.getBean("userService");

        Event event = eventService.getEventByName("concert");
        User user = userService.getUserByEmail("Petya@gmail.com");

        if (auditoriumService.assignAuditorium(event, auditoriumService.getAuditoriumByName("Main_hall")))
        System.out.println("One of auditorium is " + auditoriumService.getAuditoriumById(event.getAuditoriumId()).getName());

        System.out.println("There are " + auditoriumService.getSeatsNumber("Main_hall") + " seats in the main hall");
        System.out.println("There are " + auditoriumService.getAuditoriums().size() + " auditoriums");

        System.out.println("Is there concert in event list? " + eventService.getAllEvent().contains(eventService.getEventByName("concert")));
        eventService.removeEvent(event);
        System.out.println("Size of the events list after deleting is " + eventService.getAllEvent().size());
        eventService.createEvent(event.getName(), event.getDate(), event.getBasePrice(), event.getCapacity());
        System.out.println("Size of the events list after creation is " + eventService.getAllEvent().size());

        System.out.println("The birthmonth of Petya is " + userService.getUserByEmail("Petya@gmail.com").getBirthday().getMonth());
        System.out.println("How many Nadyas are in the user list? " + userService.getUsersByName("Nadya").size());
        System.out.println("How many tickets were booked by Petya? " + userService.getBookedTickets(user));
        userService.remove(user);
        userService.register(user);

        System.out.println("There are " + bookingService.getTicketsForEvent(event).size() + " concert tickets");
        System.out.println("Discount for Petya is " + discountService.getDiscount(user, event) * 100 + "%");
        System.out.println("Concert ticket price for Petya is " + bookingService.getTicketPrice(event, user));
    }

    }

