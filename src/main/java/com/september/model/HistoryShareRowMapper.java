package com.september.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryShareRowMapper implements RowMapper<HistoryShare> {
    @Override
    public HistoryShare mapRow(ResultSet resultSet, int i) throws SQLException {
        HistoryShare hShare = new HistoryShare();
        hShare.setIdHistoryShare(resultSet.getInt("history_id"));
        hShare.setEdrpou(resultSet.getLong("edrpou"));
        hShare.setNameField(resultSet.getString("history_name_field"));
        hShare.setOldValue(resultSet.getString("history_old_value"));
        hShare.setNewValue(resultSet.getString("history_new_value"));

        return hShare;
    }
}
