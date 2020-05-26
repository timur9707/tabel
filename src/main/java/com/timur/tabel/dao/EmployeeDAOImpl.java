package com.timur.tabel.dao;

import com.timur.tabel.entity.Employee;
import com.timur.tabel.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate, EmployeeMapper employeeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, employeeMapper);
    }

    @Override
    public List<Employee> getByDepartmentId(Integer departmentId) {
        String sql = "SELECT * FROM employees WHERE department_id = ?";
        return jdbcTemplate.query(sql, new Object[]{departmentId}, employeeMapper);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, employeeMapper);
    }
}
