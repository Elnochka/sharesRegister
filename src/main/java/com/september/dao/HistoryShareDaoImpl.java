package com.september.dao;

import com.september.model.HistoryShare;
import com.september.model.HistoryShareRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HistoryShareDaoImpl implements HistoryShareDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from history_shares ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into history_shares(edrpou, history_name_field, history_old_value, history_new_value) values (?,?,?,?)";
    @Override
    public List<HistoryShare> queryElements() {
        RowMapper<HistoryShare> rowMapper = new HistoryShareRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);
    }

    @Override
    public void insertElement(HistoryShare element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getEdrpou(), element.getNameField(),
                element.getOldValue(), element.getNewValue());

    }
}
