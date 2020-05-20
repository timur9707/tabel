package com.timur.tabel.dao;

import com.timur.tabel.entity.DateRecord;
import com.timur.tabel.mapper.DateRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class DateRecordDAOImpl implements DateRecordDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DateRecordMapper dateRecordMapper;

    @Override
    public DateRecord getByDateAndId(Date date, Long id) {
        String SQL = "SELECT * FROM employee_date_record WHERE date = ? AND employee_id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{}, dateRecordMapper);
    }

    @Override
    public List<DateRecord> getByMonthAndId(Integer month, Long id) {
        String SQL = "SELECT * FROM employee_date_record WHERE EXTRACT(MONTH FROM calendar_date) = ? AND employee_id = ?";
        return jdbcTemplate.query(SQL, new Object[]{month, id}, dateRecordMapper);
    }

    public List<DateRecord> getByMonthAndDepartmentId(Integer month, Integer department_id) {
        String SQL = "SELECT * FROM employee_date_record LEFT JOIN employees ON employee_date_record.employee_id = employees.id WHERE EXTRACT(MONTH FROM calendar_date) = ? AND employees.department_id = ?";
        return jdbcTemplate.query(SQL, new Object[]{month, department_id}, dateRecordMapper);
    }
}
