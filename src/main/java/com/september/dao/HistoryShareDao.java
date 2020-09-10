package com.september.dao;

import com.september.model.HistoryShare;

import java.util.List;

public interface HistoryShareDao {
    List<HistoryShare> queryElements();
    void insertElement(HistoryShare element);
}
