package com.timur.tabel.dao;

import com.timur.tabel.entity.Employee;
import com.timur.tabel.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAll() {
        String SQL_GET_ALL = "SELECT * FROM employees";
        return jdbcTemplate.query(SQL_GET_ALL, employeeMapper);
    }

    @Override
    public List<Employee> getByDepartmentId(Long departmentId) {
        String SQL_FIND_BY_DEPARTMENT_ID = "SELECT * FROM employees WHERE department_id = ?";
        return jdbcTemplate.query(SQL_FIND_BY_DEPARTMENT_ID, new Object[]{departmentId}, employeeMapper);
    }

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String SQL_FIND_BY_ID = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, employeeMapper);
    }



}
