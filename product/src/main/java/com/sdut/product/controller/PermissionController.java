package com.sdut.product.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PermissionController
 * @Discription  判断是否有权限 接口
 * @Author yinyuchen
 * @Date 2019/4/4 16:01
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/permission")
public class PermissionController {

    @RequestMapping(value = "addPermission")
    public Map<String, Object> addPermission(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("insert");
            map.put("code",200);
            map.put("msg", URLEncoder.encode("有权限!"));
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return map;
    }


    @RequestMapping(value = "updatePermission")
    public  Map<String, Object> updatePermission(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("update");
            map.put("code",200);
            map.put("msg",URLEncoder.encode("有权限!"));
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return map;
    }
}
