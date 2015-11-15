package com.epam.spring.service;

import com.epam.spring.DAO.DiscountStrategyDAO;
import com.epam.spring.entity.*;

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
        Double discount = 0.0;
        ArrayList<DiscountStrategy> discounts = discountStrategyDAO.getAll();

        if (user.getLuckyEvents().contains(event))
            return 1.0;
        for (DiscountStrategy ds : discounts) {
            if (isTenthTicketDiscount(ds, user))
                discount += ds.getDiscount();
            if (isBirthdayDiscount(ds, user, event))
                discount += ds.getDiscount();
        }
        return discount;
    }

    public Boolean isBirthdayDiscount(DiscountStrategy ds, User user, Event event) {
        Boolean isDiscont = false;
        if (ds.getName().equals("birthDayDiscount") && user.getBirthday().getMonth() == event.getDate().getMonth()
                && user.getBirthday().getDate() == event.getDate().getDate()) {
            isDiscont = true;
        }
        return isDiscont;
    }

    public Boolean isTenthTicketDiscount(DiscountStrategy ds, User user) {
        Boolean isDiscont = false;
        if (ds.getName().equals("tenthTicketDiscount") && user.getPaidTickets() % 10 == 9) {
            isDiscont = true;
        }
        return isDiscont;
    }

    public List<DiscountStrategy> getAllDiscounts() {
       return discountStrategyDAO.getAll();
    }

}
