package com.timur.tabel.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private LocalDate birthdate;
    private String position;
    private boolean isRemote;
    private String address;
    private int department_id;

}
