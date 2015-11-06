package com.epam.spring.service;

import com.epam.spring.DAO.DiscountStrategyDAO;
import com.epam.spring.entity.DiscountStrategy;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class DiscountService {

    private DiscountStrategyDAO discountStrategyDAO;

    public DiscountService(DiscountStrategyDAO discountStrategyDAO) {
        this.discountStrategyDAO = discountStrategyDAO;
    }

    public DiscountStrategyDAO getDiscountStrategyDAO() {
        return discountStrategyDAO;
    }

    public void setDiscountStrategyDAO(DiscountStrategyDAO discountStrategyDAO) {
        this.discountStrategyDAO = discountStrategyDAO;
    }

    public Double getDiscount(User user, Event event) {
        Double discount = 0.0;
        ArrayList<DiscountStrategy> discounts = discountStrategyDAO.getAll();
        for (DiscountStrategy ds : discounts) {
            if (ds.getName().equals("tenthTicketDiscount") && user.getPaidTickets() % 10 == 9) {
                discount += ds.getDiscount();
            }
            if (ds.getName().equals("birthDayDiscount") && user.getBirthday().getMonthValue() == event.getDate().getMonthValue()
                    && user.getBirthday().getDayOfMonth() == event.getDate().getDayOfMonth()) {
                discount += ds.getDiscount();
            }
        }
        return discount;
    }

}
