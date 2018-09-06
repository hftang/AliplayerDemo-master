package com.hftang.crm.service.impl;

import com.hftang.crm.dao.BaseDictDao;
import com.hftang.crm.domain.BaseDict;
import com.hftang.crm.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {

        return baseDictDao.findByTypeCode(dict_type_code);
    }
}
