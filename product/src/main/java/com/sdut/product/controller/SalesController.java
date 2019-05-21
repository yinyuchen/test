package com.sdut.product.controller;

import com.sdut.product.pojo.Sales;
import com.sdut.product.pojo.dto.Response;
import com.sdut.product.service.LogisticService;
import com.sdut.product.service.SalesService;
import com.sdut.product.util.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesController
 * @Discription  销售信息
 * @Author YinYuchen
 * @Date 2019/5/7 20:34
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/sales")
public class SalesController {

    @Autowired
    SalesService salesService;

    @RequestMapping(value = "getSalesAll")
    public String selectById(String str){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }else {
                str = "";
            }
            List<Object> list  = salesService.selectSalesAll(str);
            if (list!=null){
                map.put("code",200);
                map.put("msg", URLEncoder.encode("查询成功"));
                map.put("sales",list);
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

    @RequestMapping(value = "insertSales")
    public Response insertCompany(Sales sales){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("insert");
            Integer result = salesService.insertSales(sales);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("新增成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("新增失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "updateSales")
    public Response updateCompany(Sales sales){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("update");
            Integer result = salesService.updateSales(sales);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("修改成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("修改失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "deleteSales")
    public Response deleteCompany(String id){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("delete");
            Integer result = salesService.deleteById(id);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("删除成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("删除失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }
}
