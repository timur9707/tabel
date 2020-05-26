package com.timur.tabel.dao;

import com.timur.tabel.entity.DateRecord;

import java.util.Date;
import java.util.List;

public interface DateRecordDAO {

    DateRecord getByDateAndId(Date date, Long id);

    List<DateRecord> getByMonthAndId(Integer month, Long id);

    List<DateRecord> getByMonthAndDepartmentId(Integer month, Integer departmentId);

    String getMonthSummaryById(Integer month, Long id);
}
