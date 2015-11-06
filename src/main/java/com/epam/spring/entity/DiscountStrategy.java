package com.epam.spring.entity;

/**
 * Created by Daria_Tomilova on 10/24/2015.
 */
public class DiscountStrategy {

    private Double discount;
    private String name;

    public DiscountStrategy(Double discount, String name) {
        this.discount = discount;
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("discount: ").append(discount);
        sb.append("name: ").append(name);
        return sb.toString();
    }
}
