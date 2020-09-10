package com.september.service;

import com.september.model.Share;

import java.util.List;

public interface ShareService {
    List<Share> queryElements();
    Share findElementEDRPOU(Long nameElement);
    Share findElementId(Integer idElement);
    List<Share> findElementStatus(String nameElement);
    void updateElement(Share element);
    void insertElement(Share element);
    void deleteElement(Integer idElement);
}
