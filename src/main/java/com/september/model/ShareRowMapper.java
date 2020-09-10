package com.september.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareRowMapper implements RowMapper<Share> {
    @Override
    public Share mapRow(ResultSet resultSet, int i) throws SQLException {
        Share share = new Share();
        share.setIdShare(resultSet.getInt("share_id"));
        share.setComment(resultSet.getString("share_comment"));
        share.setEdrpou(resultSet.getLong("edrpou"));
        share.setQuantity(resultSet.getInt("share_quantity"));
        share.setCommonValue(resultSet.getDouble("share_common_nominal_value"));
        share.setValue(resultSet.getDouble("share_nominal_value"));
        share.setDateShare(resultSet.getString("share_date"));
        share.setStatus(resultSet.getString("share_status"));
        return share;
    }
}
