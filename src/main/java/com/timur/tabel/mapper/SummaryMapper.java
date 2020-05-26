package com.timur.tabel.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SummaryMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        StringBuilder summary = new StringBuilder();
        do {
            summary.append(resultSet.getString("code")).append("(").append(resultSet.getString("count")).append(") ");
        } while (resultSet.next());

        return summary.toString();
    }
}
