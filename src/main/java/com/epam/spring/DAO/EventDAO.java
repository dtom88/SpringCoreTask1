package com.epam.spring.DAO;

import com.epam.spring.entity.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class EventDAO {

    private JdbcTemplate jdbcTemplate;

    public EventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Event event) {
        jdbcTemplate.update("insert into events (name, date, price, capacity, auditoriumid) values (?, ?, ?, ?, ?)",
                event.getName(), event.getDate(), event.getBasePrice(), event.getCapacity(), event.getAuditoriumId());
    }

    public void remove(Event event) {
        jdbcTemplate.update("update events set isdeleted = '1' where id = ?", event.getId());
    }

    public List<Event> getAll() {
        return jdbcTemplate.query("select * from events", new RowMapper<Event>() {
            public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Date date = resultSet.getDate("Date");
                Integer price = resultSet.getInt("Price");
                Integer capacity = resultSet.getInt("Capacity");
                Integer auditoriumId = resultSet.getInt("AuditoriumId");
                Event event = new Event(id, name, date, price, capacity, auditoriumId);
                return event;
            }
        });
    }

    public Event getEventById(Integer id) {
        return jdbcTemplate.queryForObject("select * from events where id = ?", new Object[]{id},
                new RowMapper<Event>() {
                    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("Id");
                        String name = resultSet.getString("Name");
                        Date date = resultSet.getDate("Date");
                        Integer price = resultSet.getInt("Price");
                        Integer capacity = resultSet.getInt("Capacity");
                        Integer auditoriumId = resultSet.getInt("AuditoriumId");
                        Event event = new Event(id, name, date, price, capacity, auditoriumId);
                        return event;
                    }
                });
    }

    public void update(Event event) {
        Integer id = event.getId();
        jdbcTemplate.update("update events set name = ? where id = ?", event.getName(), id);
        jdbcTemplate.update("update events set date = ? where id = ?", event.getDate(), id);
        jdbcTemplate.update("update events set price = ? where id = ?", event.getBasePrice(), id);
        jdbcTemplate.update("update events set capacity = ? where id = ?", event.getCapacity(), id);
        jdbcTemplate.update("update events set auditoriumid = ? where id = ?", event.getAuditoriumId(), id);
    }

}
