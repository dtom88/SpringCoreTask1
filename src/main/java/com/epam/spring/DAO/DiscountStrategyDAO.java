package com.epam.spring.DAO;

import com.epam.spring.entity.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class DiscountStrategyDAO {
    @Autowired
    private DiscountStrategy discountStrategy;

    public DiscountStrategyDAO(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void update(DiscountStrategy discountStrategy) {
        discountStrategy.setBirthdayStrategy(discountStrategy.getBirthdayStrategy());
        discountStrategy.setTenthTiketDiscount(discountStrategy.getTenthTiketDiscount());
    }
}
