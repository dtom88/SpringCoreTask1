package com.epam.spring.service;

import com.epam.spring.DAO.UserDAO;
import com.epam.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Daria_Tomilova on 10/23/2015.
 */
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
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
       List<User> users = userDAO.getAll();
        for(User user : users) {
           if (user.getId() == id) {
               return user;
           }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        List<User> users = userDAO.getAll();
        for(User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsersByName(String name) {
        List<User> users = userDAO.getAll();
        for(User user : users) {
            if (!user.getName().equals(name)) {
                users.remove(user);
            }
        }
        return users;

    }

    public Integer getBookedTikets(User user) {
        return user.getPaidTickets();
    }

}
