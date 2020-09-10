package com.september.dao;

import com.september.model.Share;

import java.util.List;

public interface ShareDao {
    List<Share> queryElements();
    Share findElementEDRPOU(Long nameElement);
    Share findElementId(Integer idElement);
    List<Share> findElementStatus(String nameElement);
    void updateElement(Share element);
    void insertElement(Share element);
    void deleteElement(Integer idElement);
}
