package com.sdut.product.controller;

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
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
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
}
