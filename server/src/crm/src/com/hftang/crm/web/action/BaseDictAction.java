package com.hftang.crm.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hftang.crm.domain.BaseDict;
import com.hftang.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

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


    public String findByTypeCode() throws IOException {

        System.out.println("------->执行了");
        List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(BaseDict.class, "dict_id", "dict_item_code", "dict_item_name", "dict_type_name");
        String toJSONString = JSON.toJSONString(list, filter);
        System.out.println("------->执行了" + toJSONString);

        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(toJSONString);


        return NONE;
    }
}
