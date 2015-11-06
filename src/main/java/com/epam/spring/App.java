package com.epam.spring;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Daria_Tomilova on 01-Nov-15.
 */
public class App {
    private static App app;

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");

        app = (App) appContext.getBean("app");

        AuditoriumService auditoriumService = (AuditoriumService) appContext.getBean("auditoriumService");
        BookingService bookingService = (BookingService) appContext.getBean("bookingService");
        EventService eventService = (EventService) appContext.getBean("eventService");
        DiscountService discountService = (DiscountService) appContext.getBean("discountService");
        UserService userService = (UserService) appContext.getBean("userService");

        Event event = eventService.getEventByName("concert");
        User user = userService.getUserById(1);
        auditoriumService.assignAuditorium(event, auditoriumService.getAuditoriumByName("Main_hall"));

        System.out.println("If you would like to know about events type event");
        System.out.println("If you would like to know about users type user");
        System.out.println("If you would like to know about auditoriums type auditorium");
        System.out.println("If you would like to know about tickets type tickets");
        System.out.println("If you would like to know about discounts type discount");


        app.dialog();
//        System.out.println("One of auditorium is " + event.getAuditorium().getName());
//        System.out.println("There are " + auditoriumService.getVipSeats("Class_with_balcony").size() + " VIP seats in the class with balcony");
//        System.out.println("There are " + auditoriumService.getSeatsNumber("Main_hall") + " seats in the main hall");
//        System.out.println("There are " + auditoriumService.getAuditoriums().size() + " auditoriums");
//
//        System.out.println("Is there lecture between 30.01.2015 and 01.12.2015? "
//                + eventService.getForDateRange(LocalDate.of(2015, 10, 30), LocalDate.of(2015,
//                12, 01)).contains(eventService.getEventByName("lecture")));
//        System.out.println("Is there concert in event list? " + eventService.getAllEvent().contains(eventService.getEventByName("concert")));
//        eventService.removeEvent(event);
//        System.out.println("Size of the events list after deleting is " + eventService.getAllEvent().size());
//        eventService.createEvent(event.getId(), event.getName(), event.getDate(), event.getTime(),event.getBasePrice(), event.getCapacity());
//        System.out.println("Size of the events list after creation is " + eventService.getAllEvent().size());
//
//        System.out.println("The birthmonth of Petya is " + userService.getUserByEmail("petya@gmail.com").getBirthday().getMonth());
//        System.out.println("How many Nadyas are in the user list? " + userService.getUsersByName("Nadya").size());
//        System.out.println("How many tickets were booked by Petya? " + userService.getBookedTikets(user));
//        userService.remove(user);
//        userService.register(user);
//
//        System.out.println("There are " + bookingService.getTiketsForEvent(event).size() + " concert tickets");
//        System.out.println("Discount for Petya is " + discountService.getDiscount(user, event) * 100 + "%");
//        System.out.println("Concert ticket price for Petya is " + bookingService.getTicketPrice(event, 6, user));
//        bookingService.bookTicket(user, bookingService.getTiketsForEvent(event).get(5));
//        System.out.println(bookingService.getTiketsForEvent(event).get(5).getUser().getName() + " booked the concert ticket");
    }

    private void dialog() {
        String str = new String();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (str.equals("event")) {
            System.out.println("eve");
        }
        if (str.equals("ticket")) {
            System.out.println("tic");
        }
        if (str.equals("discount")) {
            System.out.println("discount");
        }
        if (str.equals("user")) {
            System.out.println("user");
        }
        if (str.equals("auditorium")) {
            System.out.println("aud");
        } else {
            return;
        }
        dialog();
    }

    }

