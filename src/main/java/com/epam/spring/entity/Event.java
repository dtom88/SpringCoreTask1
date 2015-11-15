package com.epam.spring.entity;

import java.util.Date;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Event {

    private Integer id;
    private String name;
    private Date date;
    private Integer basePrice;
    private Integer capacity;
    private Integer auditoriumId;
    private Boolean isDeleted;

    public Event(Integer id, String name, Date date, Integer basePrice, Integer capacity, Integer auditoriumId ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.basePrice = basePrice;
        this.capacity = capacity;
        this.auditoriumId = auditoriumId;
        this.isDeleted = false;
    }

    public Event(Integer id, String name, Date date, Integer basePrice, Integer capacity, Integer auditoriumId, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.basePrice = basePrice;
        this.capacity = capacity;
        this.auditoriumId = auditoriumId;
        this.isDeleted = isDeleted;
    }

    public Event(String name, Date date, Integer basePrice, Integer capacity ) {
        this.name = name;
        this.date = date;
        this.basePrice = basePrice;
        this.capacity = capacity;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(id).append("\t");
        sb.append("event_name: ").append(name).append("\t");
        sb.append("event_price: ").append(basePrice).append("\t");
        sb.append("date: ").append(date.toString()).append("\t");
        sb.append("max_event_audience.").append(capacity);

        return sb.toString();
    }
}
