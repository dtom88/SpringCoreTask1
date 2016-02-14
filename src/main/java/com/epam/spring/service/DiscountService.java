package com.epam.spring.service;

import com.epam.spring.DAO.DiscountStrategyDAO;
import com.epam.spring.entity.DiscountStrategy;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class DiscountService {

    private DiscountStrategyDAO discountStrategyDAO;

    public DiscountService(DiscountStrategyDAO discountStrategyDAO) {
        this.discountStrategyDAO = discountStrategyDAO;
    }

    public void setDiscountStrategyDAO(DiscountStrategyDAO discountStrategyDAO) {
        this.discountStrategyDAO = discountStrategyDAO;
    }

    public Double getDiscount(User user, Event event) {
        if (user == null) {
            throw new IllegalArgumentException("User should not be null");
        }
        Double discount = 0.0;
        ArrayList<DiscountStrategy> discounts = discountStrategyDAO.getAll();

        if (user.getLuckyEvents().contains(event))
            return 1.0;
        for (DiscountStrategy ds : discounts) {
            if (hasTenthTicketDiscount(user))
                discount += ds.getDiscount();
            if (hasBirthdayDiscount(user, event))
                discount += ds.getDiscount();
        }
        return discount;
    }

    public Boolean hasBirthdayDiscount(User user, Event event) {
        Boolean isDiscont = false;
        if (user.getBirthday().getMonth() == event.getDate().getMonth()
                && user.getBirthday().getDate() == event.getDate().getDate()) {
            isDiscont = true;
        }
        return isDiscont;
    }

    public Boolean hasTenthTicketDiscount(User user) {
        Boolean isDiscont = false;
        if (user.getPaidTickets() % 10 == 9) {
            isDiscont = true;
        }
        return isDiscont;
    }

    public List<DiscountStrategy> getAllDiscounts() {
        return discountStrategyDAO.getAll();
    }

    public DiscountStrategy getDiscountByName(String name) {
        return discountStrategyDAO.getDiscountByName(name);
    }
}
