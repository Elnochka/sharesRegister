package com.september.dao;

import com.september.model.Share;
import com.september.model.ShareRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ShareDaoImpl implements ShareDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from shares ";
    private static final String QUERY_FIND_ELEMENT_NAME = "Select * from shares where edrpou = ? ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from shares where share_id = ? ";
    private static final String QUERY_UPDATE_ELEMENT = "Update shares set share_comment = ?, share_quantity = ?, share_common_nominal_value =?, share_nominal_value = ?, share_date = ?, share_status = ? where share_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into shares(share_comment, edrpou, share_quantity, share_common_nominal_value, share_nominal_value, share_date, share_status) values (?,?,?,?,?,?,?)";
    private static final String QUERY_DELETE_ELEMENT = "Update shares set share_status = 'deleted' where share_id = ?";
    private static final String QUERY_FIND_ELEMENT_STATUS = "Select * from shares where share_status = ? ";

    @Override
    public List<Share> queryElements() {

        RowMapper<Share> rowMapper = new ShareRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);

    }

    @Override
    public Share findElementEDRPOU(Long nameElement) {
        RowMapper<Share> rowMapper = new ShareRowMapper();
        Share share = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_NAME, rowMapper, nameElement);
        return share;

    }

    @Override
    public Share findElementId(Integer idElement) {
        RowMapper<Share> rowMapper = new ShareRowMapper();
        Share share = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return share;

    }

    @Override
    public List<Share> findElementStatus(String nameElement) {
        RowMapper<Share> rowMapper = new ShareRowMapper();
//        Share share = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_STATUS, rowMapper, nameElement);
        return jdbcTemplate.query(QUERY_FIND_ELEMENT_STATUS, rowMapper, nameElement);

    }

    @Override
    public void updateElement(Share element) {
        jdbcTemplate.update(QUERY_UPDATE_ELEMENT, element.getComment(), element.getQuantity(), element.getCommonValue(),element.getValue(),
                element.getDateShare(), element.getStatus(), element.getIdShare());

    }

    @Override
    public void insertElement(Share element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getComment(), element.getEdrpou(), element.getQuantity(), element.getCommonValue(),element.getValue(),
                element.getDateShare(), "active");

    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }
}
