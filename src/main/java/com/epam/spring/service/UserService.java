package com.epam.spring.service;

import com.epam.spring.DAO.UserDAO;
import com.epam.spring.entity.User;

import java.util.List;

/**
 * Created by Daria_Tomilova on 10/23/2015.
 */
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.add(user);
    }

    public void remove(User user) {
        userDAO.remove(user);
    }

    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name) {
        return userDAO.getUsersByName(name);

    }

    public Integer getBookedTickets(Integer userId) {
        User user = userDAO.getUserById(userId);
        if (user == null) {
            return -1;
        }
        return user.getPaidTickets();
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }


}
