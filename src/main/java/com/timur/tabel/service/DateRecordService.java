package com.timur.tabel.service;

import com.timur.tabel.dao.*;
import com.timur.tabel.dto.EmployeeDateRecordDTO;
import com.timur.tabel.entity.DateRecord;
import com.timur.tabel.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DateRecordService {

    private EmployeeDAO employeeDAO;
    private DateRecordDAO dateRecordDAO;
    private RestTemplate restTemplate;

    @Autowired
    public DateRecordService(EmployeeDAOImpl employeeDAO, DateRecordDAO dateRecordDAO, RestTemplate restTemplate) {
        this.employeeDAO = employeeDAO;
        this.dateRecordDAO = dateRecordDAO;
        this.restTemplate = restTemplate;
    }

    public List<EmployeeDateRecordDTO> getByMonthAndDepartment(Integer month, Integer departmentId) {
        List<DateRecord> dateRecords = dateRecordDAO.getByMonthAndDepartmentId(month, departmentId);
        List<Employee> employeesByDepartment = employeeDAO.getByDepartmentId(departmentId);
        List<EmployeeDateRecordDTO> resultList = new ArrayList<>();
        for (Employee employee : employeesByDepartment) {
            EmployeeDateRecordDTO dto = new EmployeeDateRecordDTO();
            dto.setFullName(getEmployeeFullName(employee));
            dto.setId(employee.getId());
            dto.setPosition(employee.getPosition());
            if (dateRecords.size() != 0) {
                dto.setMonthSummary(dateRecordDAO.getMonthSummaryById(month, employee.getId()));
            }
            List<String> codes = dateRecordDAO.getByMonthAndId(month, employee.getId()).stream().map(dateRecord ->
                    dateRecord.getWorkStatusCode().getCode()).collect(Collectors.toList());
            dto.setCodes(codes);
            resultList.add(dto);
        }
        return resultList;
    }

    private String getEmployeeFullName(Employee employee) {
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getPatronymic();
    }

    public List<Integer> getMonthDays(Integer month) {
        String URL = "https://isdayoff.ru/api/getdata?year=2020&month=" + month;
        String s = restTemplate.getForObject(URL, String.class);
        List<Integer> res = Arrays.stream(s.split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
        return res;
    }
}
