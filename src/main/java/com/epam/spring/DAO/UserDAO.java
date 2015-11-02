package com.epam.spring.DAO;

import com.epam.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria_Tomilovq on 31-Oct-15.
 */
public class UserDAO {

    @Autowired
    private User user1;
    @Autowired
    private User user2;

    List<User> users;

    public UserDAO(User user1, User user2) {
        users = new ArrayList<User>();
        this.user1 = user1;
        this.user2 = user2;
        users.add(user1);
        users.add(user2);
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public void add(User user) {
        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public List<User> getAll() {
        return users;
    }

    public void update(User user) {
        users.get(user.getId() - 1).setName(user.getName());
        users.get(user.getId() - 1).setBirthday(user.getBirthday());
        users.get(user.getId() - 1).setEmail(user.getEmail());
        users.get(user.getId() - 1).setPaidTickets(user.getPaidTickets());
    }
}
