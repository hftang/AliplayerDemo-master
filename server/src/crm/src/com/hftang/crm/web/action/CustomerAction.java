package com.hftang.crm.web.action;

import com.hftang.crm.domain.Customer;
import com.hftang.crm.domain.PageBean;
import com.hftang.crm.service.CustomerService;
import com.hftang.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;

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
     *
     * @return
     */

    public String delete(){

      Customer customer02=  customerService.findById(customer.getCust_id());


        return NONE;
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

}
