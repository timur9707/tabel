package com.timur.tabel.dao;

import com.timur.tabel.entity.WorkStatusCode;
import com.timur.tabel.mapper.WorkStatusCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkStatusCodeDAOImpl implements WorkStatusCodeDAO {

    private JdbcTemplate jdbcTemplate;
    private WorkStatusCodeMapper workStatusCodeMapper;

    @Autowired
    public WorkStatusCodeDAOImpl(JdbcTemplate jdbcTemplate, WorkStatusCodeMapper workStatusCodeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.workStatusCodeMapper = workStatusCodeMapper;
    }

    @Override
    public WorkStatusCode getCodeById(Integer id) {
        String SQL = "SELECT * FROM work_status_code WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, workStatusCodeMapper);
    }
}
