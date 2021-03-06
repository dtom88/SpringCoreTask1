package com.epam.spring.controller;

import com.epam.spring.entity.DiscountStrategy;
import com.epam.spring.entity.Event;
import com.epam.spring.entity.User;
import com.epam.spring.service.DiscountService;
import com.epam.spring.service.EventService;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darya on 13-Feb-16.
 */
@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/users/{userId}/events/{eventId}/discount", method = RequestMethod.GET)
    public Double getDiscount(@PathVariable Integer userId, @PathVariable Integer eventId) {
        User user = userService.getUserById(userId);
        Event event = eventService.getEventById(eventId);
        if (user == null || event == null) {
            return null;
        }
        return discountService.getDiscount(user, event);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DiscountStrategy> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

}
