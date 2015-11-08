package com.epam.spring.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/23/2015.
 */
public class User {

    private Integer id;
    private String name;
    private String email;
    private LocalDate birthday;
    private Integer paidTickets;
    private List<Event> luckyEvents = new ArrayList<Event>();

    public User() {

    }

    public User(Integer id, String name, String email, LocalDate birthday, Integer paidTickets) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.birthday = birthday;
        this.paidTickets = paidTickets;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPaidTickets() {
        return paidTickets;
    }

    public List<Event> getLuckyEvents() {
        return luckyEvents;
    }

    public void setLuckyEvents(List<Event> luckyEvents) {
        this.luckyEvents = luckyEvents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPaidTickets(Integer paidTickets) {
        this.paidTickets = paidTickets;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(id);
        sb.append("user_name: ").append(name);
        sb.append("user_email: ").append(email);
        sb.append("user_b-Day: ").append(birthday.toString());
        sb.append("number_of_paid_tickets: ").append(paidTickets);
        return sb.toString();
    }
}
