package com.hftang.crm.web.action;

import com.hftang.crm.domain.BaseDict;
import com.hftang.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    private BaseDict baseDict = new BaseDict();

    private BaseDictService baseDictService;

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    @Override
    public BaseDict getModel() {

        return baseDict;
    }
}
