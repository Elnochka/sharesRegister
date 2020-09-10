package com.september.service;

import com.september.dao.ShareDao;
import com.september.model.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareDao shareDao;

    @Override
    public List<Share> queryElements() {
        return shareDao.queryElements();
    }

    @Override
    public Share findElementEDRPOU(Long nameElement) {
        Share obj = shareDao.findElementEDRPOU(nameElement);
        return obj;
    }

    @Override
    public Share findElementId(Integer idElement) {
        Share obj = shareDao.findElementId(idElement);
        return obj;
    }

    @Override
    public List<Share> findElementStatus(String nameElement) {
        return shareDao.findElementStatus(nameElement);
    }

    @Override
    public void updateElement(Share element) {
        shareDao.updateElement(element);
    }

    @Override
    public void insertElement(Share element) {
        shareDao.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        shareDao.deleteElement(idElement);
    }
}
