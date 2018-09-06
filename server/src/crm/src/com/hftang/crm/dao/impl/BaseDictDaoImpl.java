package com.hftang.crm.dao.impl;

import com.hftang.crm.dao.BaseDictDao;
import com.hftang.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {


    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {

        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().find("from BaseDict where dict_type_code = ?", dict_type_code);


        return list;
    }
}
