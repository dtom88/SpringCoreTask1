package com.epam.spring.aspectDAO;

import com.epam.spring.entity.DiscountLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daria_Tomilova on 15-Nov-15.
 */
public class DiscountAspectDAO {
    private JdbcTemplate jdbcTemplate;

    public DiscountAspectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(DiscountLog discountLog) {
        jdbcTemplate.update("insert into DiscountsLogs (userId, discountName, calls) values (?,?,?)",
                discountLog.getUserId(), discountLog.getDiscountName(), discountLog.getCounter());

    }

    public void remove(DiscountLog discountLog) {
        jdbcTemplate.update("delete from DiscountsLogs where id = ?", discountLog.getId());
    }

    public void update(String discountName, Integer userId) {
        Integer counter = jdbcTemplate.queryForObject("select calls from DiscountsLogs where userid = ? and discountName = ?",
                new Object[]{userId, discountName}, Integer.class);
        jdbcTemplate.update("update DiscountsLogs set calls = ? where userid = ? and discountName = ?",
                counter+1, userId, discountName);
    }

    public List<DiscountLog> getAll() {
        return jdbcTemplate.query("select * from DiscountsLogs", new RowMapper<DiscountLog>() {
            public DiscountLog mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                Integer userId = resultSet.getInt("UserId");
                String discountName = resultSet.getString("DiscountName");
                Integer counter = resultSet.getInt("Calls");
                DiscountLog discountLog = new DiscountLog(id, userId, discountName, counter);
                return discountLog;
            }
        });
    }

    public List<Integer> getAllUserId() {
        return jdbcTemplate.query("select userId from DiscountsLogs", new RowMapper<Integer>() {
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer userId = resultSet.getInt("userId");
                return userId;
            }
        });
    }

    public List<String> getAllDiscountsName() {
        return jdbcTemplate.query("select discountName from DiscountsLogs", new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String discName = resultSet.getString("discountName");
                return discName;
            }
        });
    }
}
