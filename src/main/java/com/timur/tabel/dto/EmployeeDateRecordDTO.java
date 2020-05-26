package com.timur.tabel.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDateRecordDTO {

    private String fullName;
    private String position;
    private Long id;
    private List<String> codes;
    private String monthSummary;
}
