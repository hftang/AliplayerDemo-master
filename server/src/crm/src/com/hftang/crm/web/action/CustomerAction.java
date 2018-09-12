package com.hftang.crm.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hftang.crm.domain.BaseDict;
import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.PageBean;
import com.hftang.crm.service.CustomerService;
import com.hftang.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    //
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public String saveUI() {
        return "saveUI";
    }

    /***
     * 文件上传 要传3个属性
     * @return
     */
    private String uploadFileName;//文件名称
    private File upload;//文件
    private String uploadContentType;//文件类型

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    //    保存的方法

    public String save() {
        //上传文件：
        if (upload != null) {
            //不为空，说明你选择了文件，才能做文件上传的操作
            //设置文件上传的路径
            String path = "/Users/hftang/Desktop";
            //一个目录下存着相同的 文件名
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            //一个目录下 存的文件过多 目录的分离
            String realPath = UploadUtils.getPath(uuidFileName);
            //创建目录
            String url = path + realPath;
            File file = new File(url);

            if (!file.exists()) {
                //如果文件不存在
                file.mkdirs();
            }
            //上传文件
            File dictFile = new File(url + "/" + uuidFileName);
            /**
             * upload 是源文件
             * dictFile  目标文件
             */
            try {
                FileUtils.copyFile(upload, dictFile);
                //保存 图片路径到数据库
                customer.setCust_img(url + "/" + uuidFileName);
            } catch (Exception e) {
                String s = e.toString();
                System.out.println(s);
            }
        }
        //保存客户
        customerService.save(customer);
        return "saveSuccess";
    }


    /***
     * 使用属性依赖
     * @return
     */

    private Integer currentPage;//当前页数

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    private Integer pageSize;//每页的记录数

    public void setPageSize(Integer pageSize) {

        this.pageSize = pageSize;
    }

    //分页查询 客户的方法
    public String findAll() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

        //设置条件
        if (customer.getCust_name() != null) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }

        if (customer.getBaseDictSource() != null) {
            if (customer.getBaseDictSource().getDict_id() != null && !"".equals(customer.getBaseDictSource().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
            }

        }

        if (customer.getBaseDictLevel() != null) {
            if (customer.getBaseDictLevel().getDict_id() != null && !"".equals(customer.getBaseDictLevel().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
            }

        }

        if (customer.getBaseDictIndustry() != null) {
            if (customer.getBaseDictIndustry().getDict_id() != null && !"".equals(customer.getBaseDictIndustry().getDict_id())) {
                detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
            }
        }


        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }

        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currentPage, pageSize);

        //向值栈里放
        ActionContext.getContext().getValueStack().push(pageBean);


        return "findAll";
    }


    //删除客户的方法

    public String delete() {
        customer = customerService.findById(customer.getCust_id());
        if (customer.getCust_img() != null) {
            File file = new File(customer.getCust_img());
            if (file.exists()) {
                file.delete();
            }
        }
        //删除客户
        customerService.delete(customer);
        return "deleteSuccess";
    }

    //编辑客户
    public String edit() {

        /***
         * 1、先查询客户 然后 保存客户 再 跳转到 编辑页面
         */

        customer = customerService.findById(this.customer.getCust_id());

        //存入值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.push(customer);


        return "editSuccess";
    }

    //update 修改

    public String update() {

        if (upload != null) {
            //说明选择了 上传文件

            String cust_img = customer.getCust_img();

            if (cust_img != null || !"".equals(cust_img)) {

                File file = new File(cust_img);
                if (file.exists()) {
                    file.delete();
                }
            }

            //设置文件上传的路径
            String path = "/Users/hftang/Desktop";
            //一个目录下存着相同的 文件名
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            //一个目录下 存的文件过多 目录的分离
            String realPath = UploadUtils.getPath(uuidFileName);
            //创建目录
            String url = path + realPath;
            File file = new File(url);

            if (!file.exists()) {
                //如果文件不存在
                file.mkdirs();
            }
            //上传文件
            File dictFile = new File(url + "/" + uuidFileName);
            /**
             * upload 是源文件
             * dictFile  目标文件
             */
            try {
                FileUtils.copyFile(upload, dictFile);
                //保存 图片路径到数据库
                customer.setCust_img(url + "/" + uuidFileName);
            } catch (Exception e) {
                String s = e.toString();
                System.out.println(s);
            }
        }
        customerService.update(customer);
        return "updateSuccess";
    }

    public String findAllCustomer() {

        List<Customer> list = customerService.findAll();
        //将list 转 json
        String toJSONString = JSON.toJSONString(list);

        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        try {
            ServletActionContext.getResponse().getWriter().print(toJSONString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return NONE;
    }

}
