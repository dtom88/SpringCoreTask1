package com.epam.spring.DAO;

import com.epam.spring.entity.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class DiscountStrategyDAO {
    private ArrayList<DiscountStrategy> discountList;

    public DiscountStrategyDAO(ArrayList<DiscountStrategy> discountList) {
        this.discountList = discountList;
    }

    public ArrayList<DiscountStrategy> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(ArrayList<DiscountStrategy> discountList) {
        this.discountList = discountList;
    }

    public void add(DiscountStrategy discountStrategy) {
        discountList.add(discountStrategy);
    }

    public void remove(DiscountStrategy discountStrategy) {
        discountList.remove(discountStrategy);
    }

    public void update(DiscountStrategy discountStrategy) {
        for (DiscountStrategy ds : discountList) {
            if (ds.getName().equals(discountStrategy.getName())) {
                discountList.remove(ds);
                ds.setName(discountStrategy.getName());
                discountList.add(ds);
                return;
            }
        }
    }

    public ArrayList<DiscountStrategy> getAll() {
        return discountList;
    }
}
