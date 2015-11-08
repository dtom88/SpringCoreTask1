package com.epam.spring.aspect;

import com.epam.spring.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daria_Tomilova on 08-Nov-15.
 */
public class DiscountAspect {
    private Map<User, Integer> userDiscountCounter;
    private Integer totalCounter;

    public DiscountAspect() {
        userDiscountCounter = new HashMap<User, Integer>();
        totalCounter = 0;
    }

    public void countGetDiscounts(User user) {
        totalCounter += 1;
        if (!userDiscountCounter.containsKey(user)) {
            userDiscountCounter.put(user, 1);
        } else {
            userDiscountCounter.put(user, userDiscountCounter.get(user) + 1);
        }
    }
}
