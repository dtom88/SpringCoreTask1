package com.epam.spring.entity;

import java.time.LocalDate;

/**
 * Created by Daria_Tomilova on 10/23/2015.
 */
public class User {

    private Integer id;
    private String name;
    private String email;
    private LocalDate birthday;
    private Integer paidTickets;

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
}
