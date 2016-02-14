package com.epam.spring.controller;

import com.epam.spring.entity.User;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darya on 13-Feb-16.
 */
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void register(User user) {
        userService.register(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(User user) {
        userService.remove(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @RequestMapping(value = "/{userId}/tickets", method = RequestMethod.GET)
    public Integer getBookedTickets(@PathVariable Integer userId) {
        return userService.getBookedTickets(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
