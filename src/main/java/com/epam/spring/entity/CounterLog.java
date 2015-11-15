package com.epam.spring.entity;

/**
 * Created by Daria_Tomilova on 15-Nov-15.
 */
public class CounterLog {
    private Integer id;
    private String methodName;
    private Integer counter;

    public CounterLog(Integer id, String methodName, Integer counter) {
        this.id = id;
        this.methodName = methodName;
        this.counter = counter;
    }

    public CounterLog(String methodName, Integer counter) {
        this.methodName = methodName;
        this.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
