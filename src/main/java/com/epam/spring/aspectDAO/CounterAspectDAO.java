package com.epam.spring.aspectDAO;

import com.epam.spring.entity.CounterLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Darya on 15-Nov-15.
 */
public class CounterAspectDAO {
    private JdbcTemplate jdbcTemplate;

    public CounterAspectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(CounterLog counterLog) {
        jdbcTemplate.update("insert into MethodUsageLogs (methodName, counter) values (?,?)",
                counterLog.getMethodName(), counterLog.getCounter());
    }

    public void remove(CounterLog counterLog) {
        jdbcTemplate.update("delete from MethodUsageLogs where id = ?", counterLog.getId());
    }

    public void update(String methodName) {
        Integer counter = jdbcTemplate.queryForObject("select counter from MethodUsageLogs where methodName = ?",
                new Object[]{methodName}, Integer.class);
        jdbcTemplate.update("update MethodUsageLogs set counter = ? where methodName = ?", counter+1, methodName);
    }

    public List<CounterLog> getAll() {
       return jdbcTemplate.query("select * from MethodUsageLogs", new RowMapper<CounterLog>() {
            public CounterLog mapRow(ResultSet resultSet, int i) throws SQLException {
                String methName = resultSet.getString("methodName");
                Integer counter = resultSet.getInt("counter");
                Integer id = resultSet.getInt("Id");
                CounterLog counterLog = new CounterLog(id, methName, counter);
                return counterLog;
            }
        });
    }

    public List<String> getAllMetodNames() {
        return jdbcTemplate.query("select MethodName from MethodUsageLogs", new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String methodName = resultSet.getString("MethodName");
                return methodName;
            }
        });
    }

}
