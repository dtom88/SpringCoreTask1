package com.epam.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Auditorium {

    private Integer id;
    private String name;
    private Integer numbersOfSeats;
    private List<Date> calendar;

    public Auditorium(Integer id, String name, Integer numbersOfSeats) {
        this.id = id;
        this.name = name;
        this.numbersOfSeats = numbersOfSeats;
        calendar = new ArrayList<Date>();
    }

    public Auditorium(String name, Integer numbersOfSeats, List<Date> calendar) {
        this.name = name;
        this.numbersOfSeats = numbersOfSeats;
        this.calendar = calendar;
    }

    public Auditorium() {
    }

    public String getName() {
        return name;
    }

    public Integer getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public List<Date> getCalendar() {
        return calendar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumbersOfSeats(Integer numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCalendar(List<Date> calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(id).append("\t");
        sb.append("auditorium_name: ").append(name).append("\t");
        sb.append("number_of_seats: ").append(numbersOfSeats);
        return sb.toString();
    }
}
