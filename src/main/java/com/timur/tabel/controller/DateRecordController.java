package com.timur.tabel.controller;

import com.timur.tabel.dto.EmployeeDateRecordDTO;
import com.timur.tabel.service.DateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DateRecordController {

    @Autowired
    private DateRecordService dateRecordService;

    @GetMapping("/getRecordsByMonthAndDepartment")
    public List<EmployeeDateRecordDTO> getRecordsByMonthDepartment(Integer month, Integer departmentId) {
       return dateRecordService.getByMonthAndDepartment(month, departmentId);
    }

    @GetMapping("/getMonthDays")
    public List<Integer> getMonthDays(Integer month) {
        return dateRecordService.getMonthDays(month);
    }
}
