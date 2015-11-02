package com.epam.spring.entity;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class DiscountStrategy {

    private Double birthdayStrategy;
    private Double tenthTiketDiscount;

    public DiscountStrategy(Double birthdayStrategy, Double tenthTiketDiscount) {
        this.birthdayStrategy = birthdayStrategy;
        this.tenthTiketDiscount = tenthTiketDiscount;
    }

    public Double getBirthdayStrategy() {
        return birthdayStrategy;
    }

    public Double getTenthTiketDiscount() {
        return tenthTiketDiscount;
    }

    public void setBirthdayStrategy(Double birthdayStrategy) {
        this.birthdayStrategy = birthdayStrategy;
    }

    public void setTenthTiketDiscount(Double tenthTiketDiscount) {
        this.tenthTiketDiscount = tenthTiketDiscount;
    }
}
