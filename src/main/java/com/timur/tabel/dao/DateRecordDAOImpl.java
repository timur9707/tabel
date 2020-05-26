package com.timur.tabel.dao;

import com.timur.tabel.entity.DateRecord;
import com.timur.tabel.mapper.DateRecordMapper;
import com.timur.tabel.mapper.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public class DateRecordDAOImpl implements DateRecordDAO {

    private  JdbcTemplate jdbcTemplate;
    private  DateRecordMapper dateRecordMapper;
    private  SummaryMapper summaryMapper;


    @Autowired
    public DateRecordDAOImpl(JdbcTemplate jdbcTemplate, DateRecordMapper dateRecordMapper, SummaryMapper summaryMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.dateRecordMapper = dateRecordMapper;
        this.summaryMapper = summaryMapper;
    }

    public String getMonthSummaryById(Integer month, Long id) {

        String sql = "SELECT COUNT(code_id), work_status_code.code FROM employee_date_record " +
                "    LEFT JOIN work_status_code ON employee_date_record.code_id = work_status_code.id" +
                "    WHERE EXTRACT(MONTH FROM calendar_date) = ? AND employee_id = ? GROUP BY code";

        return jdbcTemplate.queryForObject(sql, new Object[]{month,id}, summaryMapper);
    }

    @Override
    public DateRecord getByDateAndId(Date date, Long id) {
        String sql = "SELECT * FROM employee_date_record WHERE date = ? AND employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, dateRecordMapper);
    }

    @Override
    public List<DateRecord> getByMonthAndId(Integer month, Long id) {
        String sql = "SELECT * FROM employee_date_record WHERE EXTRACT(MONTH FROM calendar_date) = ? AND employee_id = ?";
        return jdbcTemplate.query(sql, new Object[]{month, id}, dateRecordMapper);
    }

    public List<DateRecord> getByMonthAndDepartmentId(Integer month, Integer department_id) {
        String sql = "SELECT * FROM employee_date_record LEFT JOIN employees ON employee_date_record.employee_id = employees.id WHERE EXTRACT(MONTH FROM calendar_date) = ? AND employees.department_id = ?";
        return jdbcTemplate.query(sql, new Object[]{month, department_id}, dateRecordMapper);
    }
}
