package com.hftang.crm.dao;

import com.hftang.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {

    List<BaseDict> findByTypeCode(String dict_type_code);
}
