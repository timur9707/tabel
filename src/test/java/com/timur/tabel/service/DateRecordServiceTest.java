package com.timur.tabel.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DateRecordServiceTest {

    @Autowired
    DateRecordService dateRecordService;

    @Test
    void getByMonthAndDepartment() {
        assertEquals(2, dateRecordService.getByMonthAndDepartment(5, 1).size());
    }

    @Test
    void getMonthDays() {
        List<Integer> aprilDays = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(aprilDays, dateRecordService.getMonthDays(4));
    }
}