package com.epam.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/23/2015.
 */
public class User {

    private Integer id;
    private String name;
    private String email;
    private Date birthday;
    private Integer paidTickets;
    private List<Event> luckyEvents = new ArrayList<Event>();

    public User(Integer id, String name, String email, Date birthday, Integer paidTickets) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.birthday = birthday;
        this.paidTickets = paidTickets;
    }

    public User(String name, String email, Date birthday, Integer paidTickets) {
        this.name = name;
        this.email = email;
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

    public Date getBirthday() {
        return birthday;
    }

    public Integer getPaidTickets() {
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPaidTickets(Integer paidTickets) {
        this.paidTickets = paidTickets;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(id).append("\t");
        sb.append("user_name: ").append(name).append("\t");
        sb.append("user_email: ").append(email).append("\t");
        sb.append("user_b-Day: ").append(birthday.toString()).append("\t");
        sb.append("number_of_paid_tickets: ").append(paidTickets);
        return sb.toString();
    }
}
