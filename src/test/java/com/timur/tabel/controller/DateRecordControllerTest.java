package com.timur.tabel.controller;

import com.timur.tabel.dto.EmployeeDateRecordDTO;
import com.timur.tabel.service.DateRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DateRecordControllerTest {

    @Autowired
    DateRecordController dateRecordController;

    @Test
    void getRecordsByMonthDepartment() {
        assertEquals(2, dateRecordController.getRecordsByMonthDepartment(5, 1).size());
    }

    @Test
    void getMonthDays() {
        List<Integer> aprilDays = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(aprilDays, dateRecordController.getMonthDays(4));
    }
}