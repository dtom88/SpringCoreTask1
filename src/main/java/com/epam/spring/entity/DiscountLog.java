package com.epam.spring.entity;

/**
 * Created by Daria_Tomilova on 15-Nov-15.
 */
public class DiscountLog {
    private Integer id;
    private Integer userId;
    private String discountName;
    private Integer counter;

    public DiscountLog(Integer userId, String discountName, Integer counter) {
        this.userId = userId;
        this.discountName = discountName;
        this.counter = counter;
    }

    public DiscountLog(Integer id, Integer userId, String discountName, Integer counter) {
        this.id = id;
        this.userId = userId;
        this.discountName = discountName;
        this.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
