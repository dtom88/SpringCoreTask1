package com.epam.spring.DAO;

import com.epam.spring.entity.Auditorium;
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
public class AuditoriumDAO {

    private JdbcTemplate jdbcTemplate;

    public AuditoriumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Auditorium auditorium) {
        jdbcTemplate.update("insert into auditoriums (name, capacity) values ( ?, ?)", auditorium.getName(),
                auditorium.getNumbersOfSeats());
    }

    public void remove(Auditorium auditorium) {
        jdbcTemplate.update("delete from auditoriums where id = ?", auditorium.getId());
    }

    public void update(Auditorium auditorium) {
        jdbcTemplate.update("update auditoriums set name = ? where id = ?", auditorium.getName(), auditorium.getId());
        jdbcTemplate.update("update auditoriums set capacity = ? where id = ?", auditorium.getNumbersOfSeats(), auditorium.getId());
}

    public List<Auditorium> getAll() {
        return jdbcTemplate.query("select * from auditoriums", new RowMapper<Auditorium>() {
            public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Integer capacity = resultSet.getInt("capacity");
                Auditorium auditorium = new Auditorium(id, name, capacity);
                return auditorium;
            }
        });
    }

    public Auditorium getAuditoriumByName(String name) {
        Auditorium auditorium = jdbcTemplate.queryForObject("select * from auditoriums where name = ?", new Object[]{name},
                new RowMapper<Auditorium>() {
                    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("Id");
                        String name = resultSet.getString("Name");
                        Integer capacity = resultSet.getInt("capacity");
                        Auditorium auditorium = new Auditorium(id, name, capacity);
                        return auditorium;
                    }
                });
        List<Date> calendar = jdbcTemplate.query("select * from calendar where auditoriumId = ?", new Object[]{auditorium.getId()},
                new RowMapper<Date>() {
                    public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getDate("Date");
                    }
                });
        auditorium.setCalendar(calendar);
        return auditorium;
    }
    public Auditorium getAuditoriumById(Integer id) {
        final List<Date> calendar = jdbcTemplate.query("select * from calendar where auditoriumId = ?", new Object[]{id},
                new RowMapper<Date>() {
                    public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getDate("Date");
                    }
                });
        Auditorium auditorium = jdbcTemplate.queryForObject("select * from auditoriums where id = ?", new Object[]{id},
                new RowMapper<Auditorium>() {
                    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                        Integer id = resultSet.getInt("Id");
                        String name = resultSet.getString("Name");
                        Integer capacity = resultSet.getInt("capacity");
                        Auditorium auditorium = new Auditorium(id, name, capacity);
                        return auditorium;
                    }
                });
        auditorium.setCalendar(calendar);
        return auditorium;
    }

    public void updateCalendar(Event event, Auditorium auditorium) {
        jdbcTemplate.update("insert into calendar (auditoriumid, date, eventid) values(?, ?, ?)",
                auditorium.getId(), event.getDate(), event.getId());
    }

}
