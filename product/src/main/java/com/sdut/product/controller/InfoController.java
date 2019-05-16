package com.sdut.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdut.product.pojo.Information;
import com.sdut.product.service.HotSalesService;
import com.sdut.product.service.InfoService;
import com.sdut.product.util.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.*;

/**
 * @ClassName InfoController
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:30
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    HotSalesService hotSalesService;

    /**
     * @Author yinyuchen
     * @Description //TODO    前台 根据 id 查询信息
     * @Date 17:08 2019/4/16
     * @Param [id]
     * @return com.sdut.product.bean.Information
     **/

    @RequestMapping(value = "/selectById")
    public Information selectById(String id){
        Information information = infoService.selectById(id);
        return information;
    }


    @RequestMapping(value="/getInfoAll")
    public String getProductAll(String str){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            int total = 0;
            total= infoService.selectCount(str);
            map = infoService.selectAll(str);
            map.put("total",total);
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return JsonUtils.mapToJson(map);
    }

    @RequestMapping(value = "/deleteById")
    public int deleteById(String id){
        int result = 0;
//        result = infoService.deleteByPrimaryKey(id);
        return result;
    }

    @RequestMapping(value = "/updateById")
    public int updateById(String str){
        JSONObject json = JSONObject.parseObject(str);
        Information information = new Information();
        information.setId(json.get("id")+"");
        information.setName(json.get("name")+"");

        int result = 0;
//        result = infoService.updateByPrimaryKey(information);

        return result;
    }

    @RequestMapping(value = "/insert")
    public int insert(String str){
        JSONObject json = JSONObject.parseObject(str);
        Information information = new Information();
        information.setId(json.get("id")+"");
        information.setName(json.get("name")+"");

        int result = 0;
        Information info = infoService.selectById(information.getId());
        if (info==null){
//            result = infoService.insert(information);
        }

        return result;
    }

    @RequestMapping(value = "/deleteByIds")
    public int deleteByIds(String str){
        int result = 0;

        JSONObject json = JSONObject.parseObject(str);
        String ids = json.get("ids")+"";
//        result = infoService.deleteByIds(ids);
        return result;
    }
}
