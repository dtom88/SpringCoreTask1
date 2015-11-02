package com.epam.spring.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Auditorium {

    private Integer id;
    private String name;
    private Integer numbersOfSeats;
    private List<Integer> vipSeats;
    private List<LocalDate> calendar;

    public Auditorium(Integer id, String name, Integer numbersOfSeats, List<Integer> vipSeats) {
        this.id = id;
        this.name = name;
        this.numbersOfSeats = numbersOfSeats;
        this.vipSeats = vipSeats;
        calendar = new ArrayList<LocalDate>();
    }

    public Auditorium() {
    }

    public String getName() {
        return name;
    }

    public Integer getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public List<Integer> getVipSeats() {
        return vipSeats;
    }

    public List<LocalDate> getCalendar() {
        return calendar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumbersOfSeats(Integer numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }

    public void setVipSeats(List<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCalendar(List<LocalDate> calendar) {
        this.calendar = calendar;
    }
}
