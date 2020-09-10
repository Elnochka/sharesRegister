package com.september.service;

import com.september.dao.HistoryShareDao;
import com.september.model.HistoryShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryShareServiceImpl implements HistoryShareService {
    @Autowired
    private HistoryShareDao historyShareDao;
    @Override
    public List<HistoryShare> queryElements() {
        return historyShareDao.queryElements();
    }

    @Override
    public void insertElement(HistoryShare element) {
        historyShareDao.insertElement(element);

    }
}
