package com.timur.tabel.mapper;

import com.timur.tabel.entity.WorkStatusCode;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WorkStatusCodeMapper implements RowMapper<WorkStatusCode> {
    @Override
    public WorkStatusCode mapRow(ResultSet resultSet, int i) throws SQLException {
        WorkStatusCode workStatusCode = new WorkStatusCode();
        workStatusCode.setId(resultSet.getInt("id"));
        workStatusCode.setCode(resultSet.getString("code"));
        workStatusCode.setDescription(resultSet.getString("description"));
        return workStatusCode;
    }
}
