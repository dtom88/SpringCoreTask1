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

    public void countGetDiscounts(Object user) {
        totalCounter += 1;
        if (!userDiscountCounter.containsKey(user)) {
            userDiscountCounter.put((User) user, 1);
        } else {
            userDiscountCounter.put((User) user, userDiscountCounter.get(user) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (User user : userDiscountCounter.keySet()) {
            sb.append(user.getName()).append("'s discount was asked ").append(userDiscountCounter.get(user)).append(" times; ");
        }
        sb.append("Discounts were asked ").append(totalCounter).append(" times.");
        return sb.toString();
    }
}
