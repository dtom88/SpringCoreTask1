package com.epam.spring.entity;

import java.lang.Integer;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class Ticket {
    private Integer id;
    private Integer eventId;
    private Integer seat;
    private Integer userId;
    private boolean isSold;
    private Double sellPrice;

    public Ticket(Integer id, Integer eventId, Integer seat, Integer userId, boolean isSold, Double sellPrice) {
        this.id = id;
        this.eventId = eventId;
        this.seat = seat;
        this.userId = userId;
        this.isSold = isSold;
        this.sellPrice = sellPrice;
    }

    public Ticket(Integer eventId, Integer seat, Integer userId, boolean isSold, Double sellPrice) {
        this.eventId = eventId;
        this.seat = seat;
        this.userId = userId;
        this.isSold = isSold;
        this.sellPrice = sellPrice;
    }

    public Integer getEventId() {
        return eventId;
    }

    public Integer getSeat() {
        return seat;
    }

    public Integer getUserId() {
        return userId;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(id).append("\t");
        sb.append("ticket_event: ").append(eventId).append("\t");
        sb.append("seat_number: ").append(seat).append("\t");
        if(isSold) {
            sb.append("ticket is sold and its sell price is ").append(sellPrice);
        } else sb.append("ticket is not sold.");

        return sb.toString();
    }

}
