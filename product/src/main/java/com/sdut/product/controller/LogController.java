package com.sdut.product.controller;

import com.sdut.product.pojo.Logs;
import com.sdut.product.pojo.dto.Response;
import com.sdut.product.service.LogService;
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
 * @ClassName LogController  读取、插入日志
 * @Discription
 * @Author YinYuchen
 * @Date 2019/5/20 15:48
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/log")
public class LogController {
    @Autowired
    LogService logService;

    @RequestMapping(value = "getLogAll")
    public String selectById(String str){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            List<Object> list  = logService.selectLogAll(str);
            if (list!=null){
                map.put("code",200);
                map.put("msg", URLEncoder.encode("查询成功"));
                map.put("logistic",list);
            }else {
                map.put("code",500);
                map.put("msg",URLEncoder.encode("查询失败"));
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return JsonUtils.mapToJson(map);
    }

    @RequestMapping(value = "insertLog")
    public Response insertCompany(Logs log){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("insert");
            Integer result = logService.insertLog(log);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("新增成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("新增失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

}
