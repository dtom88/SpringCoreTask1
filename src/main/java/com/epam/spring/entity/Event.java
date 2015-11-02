package com.epam.spring.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Event {

    private Integer id;
    private String name;
    private LocalDate date;
    private String time;
    private Integer basePrice;
    private Integer capacity;
    private Auditorium auditorium;

    public Event(Integer id, String name, LocalDate date, String time, Integer basePrice, Integer capacity) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.basePrice = basePrice;
        this.capacity = capacity;
        auditorium = new Auditorium();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
