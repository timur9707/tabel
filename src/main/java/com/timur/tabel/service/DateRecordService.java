package com.timur.tabel.service;

import com.timur.tabel.dao.*;
import com.timur.tabel.dto.EmployeeDateRecordDTO;
import com.timur.tabel.entity.DateRecord;
import com.timur.tabel.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DateRecordService {

    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    DateRecordDAO dateRecordDAO;

    public List<EmployeeDateRecordDTO> getByMonthAndDepartment(Integer month, Integer departmentId) {
        List<DateRecord> dateRecords = dateRecordDAO.getByMonthAndDepartmentId(month, departmentId);
        List<Employee> employeesByDepartment = employeeDAO.getByDepartmentId(1L);

        List<EmployeeDateRecordDTO> resultList = new ArrayList<>();

        for (Employee employee : employeesByDepartment) {
            EmployeeDateRecordDTO dto = new EmployeeDateRecordDTO();
            dto.setFullName(getEmployeeFullName(employee));
            dto.setId(employee.getId());
            dto.setPosition(employee.getPosition());
            List<DateRecord> recordsPerMonth = dateRecordDAO.getByMonthAndId(month, employee.getId());
            List<String> codes = new ArrayList<>();
            for (DateRecord dateRecord : recordsPerMonth) {
                codes.add(dateRecord.getWorkStatusCode().getCode());
            }
            dto.setCodes(codes);
            resultList.add(dto);
        }

        return resultList;
    }

    private String getEmployeeFullName(Employee employee) {
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getPatronymic();
    }
}
