package com.september.service;

import com.september.model.HistoryShare;

import java.util.List;

public interface HistoryShareService {
    List<HistoryShare> queryElements();
    void insertElement(HistoryShare element);
}
