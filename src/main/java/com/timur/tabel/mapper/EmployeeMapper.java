package com.timur.tabel.mapper;

import com.timur.tabel.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPatronymic(resultSet.getString("patronymic"));
        employee.setAge(resultSet.getInt("age"));
        employee.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
        employee.setPosition(resultSet.getString("position"));
        employee.setRemote(resultSet.getBoolean("is_remote"));
        employee.setAddress(resultSet.getString("address"));
        employee.setDepartment_id(resultSet.getInt("department_id"));
        return employee;
    }
}
