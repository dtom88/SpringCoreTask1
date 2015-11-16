package com.epam.spring.aspect;

import com.epam.spring.aspectDAO.DiscountAspectDAO;
import com.epam.spring.entity.DiscountLog;
import com.epam.spring.entity.DiscountStrategy;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.DiscountService;
import com.epam.spring.service.UserService;
import org.aspectj.lang.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daria_Tomilova on 08-Nov-15.
 */
@Aspect
public class DiscountAspect {

    private DiscountAspectDAO discountAspectDAO;


    public DiscountAspect(DiscountAspectDAO discountAspectDAO) {
        this.discountAspectDAO = discountAspectDAO;
    }

    @AfterReturning (pointcut = "execution(Boolean com.epam.spring.service.DiscountService.isBirthdayDiscount(..)) && args(ds, user,..)",
            returning="retVal")
    public void countBirthdayDiscount(Boolean retVal, DiscountStrategy ds, User user) {
        if (retVal) {
            if (!discountAspectDAO.getAllUserId().contains(user.getId()) ||
                    !discountAspectDAO.getAllDiscountsName().contains(ds.getName())) {
                discountAspectDAO.add(new DiscountLog(user.getId(), ds.getName(), 1));
            } else {
                discountAspectDAO.update(ds.getName(), user.getId());
            }
        }
    }

    @AfterReturning (pointcut = "execution(Boolean com.epam.spring.service.DiscountService.isTenthTicketDiscount(..)) && args(ds, user)",
            returning = "retVal")
    public void countTenthTicketDiscount(Boolean retVal, DiscountStrategy ds, User user) {
        if (retVal) {
            if (!discountAspectDAO.getAllUserId().contains(user.getId()) ||
                    !discountAspectDAO.getAllDiscountsName().contains(ds.getName())) {
                discountAspectDAO.add(new DiscountLog(user.getId(), ds.getName(), 1));
            } else {
                discountAspectDAO.update(ds.getName(), user.getId());
            }
        }
    }
}
