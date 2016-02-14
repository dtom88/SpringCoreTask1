package com.epam.spring.DAO;

import com.epam.spring.entity.DiscountStrategy;

import java.util.ArrayList;
import java.util.Iterator;

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

    public DiscountStrategy getDiscountByName(String name) {
//       return discountList.stream().filter(ds -> name.equals(ds.getName())).findAny().get();
        Iterator iterator = discountList.iterator();
        DiscountStrategy ds = (DiscountStrategy) iterator.next();
        while (!name.equals(ds.getName())) {
            ds = (DiscountStrategy) iterator.next();
        }
        return ds;
    }
}
