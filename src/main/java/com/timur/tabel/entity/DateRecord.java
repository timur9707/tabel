package com.timur.tabel.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DateRecord {

    private LocalDate calendarDate;
    private Long employeeId;
    private WorkStatusCode workStatusCode;
}
