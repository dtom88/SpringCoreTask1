package com.epam.spring.DAO;

import com.epam.spring.entity.Event;
import com.epam.spring.entity.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daria_Tomilova on 31-Oct-15.
 */
public class TicketDAO {
    private JdbcTemplate jdbcTemplate;

    public TicketDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Ticket ticket) {
        jdbcTemplate.update("insert into tickets (eventid, seat, userid, sellprice, issold) values (?, ?, ?, ?, ?)",
                ticket.getEventId(), ticket.getSeat(), ticket.getUserId(), ticket.getSellPrice(), ticket.getIsSold());
    }

    public void remove(Ticket ticket) {
        jdbcTemplate.update("delete from tickets where id = ?", ticket.getId());
    }

    public void update(Ticket ticket) {
        Integer id = ticket.getId();
        jdbcTemplate.update("update tickets set userid = ? where id = ?", ticket.getUserId(), id);
        jdbcTemplate.update("update tickets set sellprise = ? where id = ?", ticket.getSellPrice(), id);
        jdbcTemplate.update("update tickets set issold = ? where id = ?", ticket.getIsSold(), id);
    }

    public List<Ticket> getAll(Event event) {
        return jdbcTemplate.query("select * from tickets where eventId = ?", new Object[]{event.getId()}, new RowMapper<Ticket>() {
            public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("Id");
                Integer eventId = resultSet.getInt("eventId");
                Integer seat = resultSet.getInt("seat");
                Integer userId = resultSet.getInt("userId");
                Double sellPrice = resultSet.getDouble("sellPrice");
                Boolean isSold = resultSet.getBoolean("isSold");
                Ticket ticket = new Ticket(id, eventId,seat,userId, isSold, sellPrice);
                return ticket;
            }
        });
    }

    public void createTicketsForEvent(Event event) {
        for (int i = 0; i < event.getCapacity(); i ++) {
            jdbcTemplate.update("insert into tickets (eventId, seat, userId, sellPrice, isSold) values (?,?,?,?,?)",
                    event.getId(), i+1, null, null, '0');
        }
    }
}
