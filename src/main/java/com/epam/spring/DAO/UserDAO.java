package com.epam.spring.DAO;

import com.epam.spring.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daria_Tomilovq on 31-Oct-15.
 */
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        jdbcTemplate.update("insert into users (name, email, birthday, paidtickets) values (?,?,?,?)",
                user.getName(), user.getEmail(), user.getBirthday(), user.getPaidTickets());
    }

    public void remove(User user) {
        jdbcTemplate.update("delete from users where id = ?", user.getId());
    }

    public List<User> getAll() {
        return jdbcTemplate.query("select * from users", new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                Integer paidTickets = resultSet.getInt("paidTickets");
                User user = new User(id, name, email, birthday, paidTickets);
                return user;
            }
        });
    }

    public User getUserById(Integer id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[]{id},
                new RowMapper<User>() {
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        Date birthday = resultSet.getDate("birthday");
                        Integer paidTickets = resultSet.getInt("paidTickets");
                        User user = new User(id, name, email, birthday, paidTickets);
                        return user;
                    }
                });
    }
    public void update(User user) {
        Integer id = user.getId();
        jdbcTemplate.update("update users set email = ? where id = ?", user.getEmail(), id);
        jdbcTemplate.update("update users set paidtickets = ? where id = ?", user.getPaidTickets(), id);
    }

    public List<User> getUsersByName(String name) {
        return jdbcTemplate.query("select * from users where name = ?", new Object[]{name},
                new RowMapper<User>() {
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        Date birthday = resultSet.getDate("birthday");
                        Integer paidTickets = resultSet.getInt("paidTickets");
                        User user = new User(id, name, email, birthday, paidTickets);
                        return user;
                    }
                });
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("select * from users where email = ?", new Object[]{email},
                new RowMapper<User>() {
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        Date birthday = resultSet.getDate("birthday");
                        Integer paidTickets = resultSet.getInt("paidTickets");
                        User user = new User(id, name, email, birthday, paidTickets);
                        return user;
                    }
                });
    }
}
