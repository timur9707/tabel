package com.timur.tabel.dao;

import com.timur.tabel.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    Employee getEmployeeById(Long id);

    List<Employee> getAll();

    List<Employee> getByDepartmentId(Integer departmentId);
}
