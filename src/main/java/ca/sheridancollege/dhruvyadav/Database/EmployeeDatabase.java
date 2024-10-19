package ca.sheridancollege.dhruvyadav.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.dhruvyadav.beans.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDatabase {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        String sql = "SELECT * FROM Employee WHERE endDate = :currentDate";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("currentDate", LocalDate.now());
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee findById(Long id) {
        String sql = "SELECT * FROM Employee WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int save(Employee employee) {
        String sql = "INSERT INTO Employee (title, department, startDate, endDate, age) VALUES (:title, :department, :startDate, :endDate, :age)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", employee.getTitle());
        params.addValue("department", employee.getDepartment());
        params.addValue("startDate", employee.getStartDate());
        params.addValue("endDate", employee.getEndDate());
        params.addValue("age", employee.getAge());
        return jdbcTemplate.update(sql, params);
    }

    public int update(Employee employee) {
        String sql = "UPDATE Employee SET title = :title, department = :department, startDate = :startDate, endDate = :endDate, age = :age WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", employee.getId());
        params.addValue("title", employee.getTitle());
        params.addValue("department", employee.getDepartment());
        params.addValue("startDate", employee.getStartDate());
        params.addValue("endDate", employee.getEndDate());
        params.addValue("age", employee.getAge());
        return jdbcTemplate.update(sql, params);
    }

    public int delete(Long id) {
        String sql = "DELETE FROM Employee WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.update(sql, params);
    }
}
