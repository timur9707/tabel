package com.timur.tabel.mapper;

import com.timur.tabel.dao.WorkStatusCodeDAO;
import com.timur.tabel.entity.DateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DateRecordMapper implements RowMapper<DateRecord> {

    @Autowired
    WorkStatusCodeDAO workStatusCodeDAO;

    @Override
    public DateRecord mapRow(ResultSet resultSet, int i) throws SQLException {
        DateRecord record = new DateRecord();
        record.setCalendarDate(resultSet.getDate("calendar_date").toLocalDate());
        record.setEmployeeId(resultSet.getLong("employee_id"));
        record.setWorkStatusCode(workStatusCodeDAO.getCodeById(resultSet.getInt("code_id")));
        return record;
    }
}
