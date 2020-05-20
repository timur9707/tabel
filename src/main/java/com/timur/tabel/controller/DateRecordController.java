package com.timur.tabel.controller;

import com.timur.tabel.dto.EmployeeDateRecordDTO;
import com.timur.tabel.service.DateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DateRecordController {


    @Autowired
    DateRecordService dateRecordService;

    @GetMapping("/getAll")
    public List<EmployeeDateRecordDTO> getRecordsByMonthDepartment(Integer month, Integer departmentId) {
       return dateRecordService.getByMonthAndDepartment(month, departmentId);
    }

    @GetMapping("/test")
    public List<EmployeeDateRecordDTO> getRecordsByMonthDepartmentTest() {

        return dateRecordService.getByMonthAndDepartment(5, 1);
    }

}
