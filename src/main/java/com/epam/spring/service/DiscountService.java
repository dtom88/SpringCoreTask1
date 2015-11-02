package com.epam.spring.service;

import com.epam.spring.DAO.DiscountStrategyDAO;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class DiscountService {

    @Autowired
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
        if (user.getPaidTickets() % 10 == 9) {
            discount += discountStrategyDAO.getDiscountStrategy().getTenthTiketDiscount();
        }
        if (user.getBirthday().getMonthValue() == event.getDate().getMonthValue()
                && user.getBirthday().getDayOfMonth() == event.getDate().getDayOfMonth()) {
            discount += discountStrategyDAO.getDiscountStrategy().getBirthdayStrategy();
        }
        return discount;
    }
}
