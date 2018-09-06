package com.hftang.crm.service.impl;

import com.hftang.crm.dao.BaseDictDao;
import com.hftang.crm.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
