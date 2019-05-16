package com.sdut.product.controller;

import com.sdut.product.pojo.Company;
import com.sdut.product.pojo.dto.Response;
import com.sdut.product.service.CompanyService;
import com.sdut.product.util.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yinyuchen
 * @Description //TODO   公司信息
 * @Date 10:10 2019/3/28
 * @Param
 * @return
 **/

@RestController
@CrossOrigin
@RequestMapping(value="/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "getCompanyAll")
    public String selectCompanyAll(String str){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            List<Object> list  = companyService.selectCompanyAll(str);
            if (list!=null){
                map.put("code",200);
                map.put("msg",URLEncoder.encode("查询成功"));
                map.put("company",list);
            }else {
                map.put("code",500);
                map.put("msg",URLEncoder.encode("查询失败"));
            }

        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return JsonUtils.mapToJson(map);
    }

    @RequestMapping(value = "insertCompany")
    public Response insertCompany(Company company){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("insert");
            Integer result = companyService.insertCompany(company);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("新增成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("新增失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "updateCompany")
    public Response updateCompany(Company company){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("update");
            Integer result = companyService.insertCompany(company);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("修改成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("修改失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "deleteCompany")
    public Response deleteCompany(String id){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("delete");
            Integer result = companyService.deleteById(id);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("删除成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("删除失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "selectById")
    public Company selectById(String id){
        return companyService.selectById(id);
    }

}
