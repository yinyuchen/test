package com.sdut.product.controller;

import com.sdut.product.pojo.FeedBack;
import com.sdut.product.pojo.dto.Response;
import com.sdut.product.service.FeedBackService;
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
 *  反馈 接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "feedback")
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;

    @RequestMapping(value = "getFeedBackAll")
    public String selectFeedbackAll(String str){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            List<Object> list  = feedBackService.selectFeedBackAll(str);
            if (list!=null){
                map.put("code",200);
                map.put("msg", URLEncoder.encode("查询成功"));
                map.put("feedback",list);
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

    @RequestMapping(value = "getFeedBackById")
    public String selectFeedbackById(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("view");
            FeedBack feedBack  = feedBackService.selectFeedBackById(id);
            if (feedBack!=null){
                map.put("code",200);
                map.put("msg", URLEncoder.encode("查询成功"));
                map.put("feedback",feedBack);
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

    @RequestMapping(value = "insertFeedback")
    public Response<Object> insertFeedbackAll(FeedBack feedBack){
        System.out.println("feedback---"+feedBack.toString());
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("insert");
            Integer result = feedBackService.insertFeedBack(feedBack);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("新增成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("新增失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

    @RequestMapping(value = "updateFeedback")
    public Response<Object> updateFeedbackById(String id){
        try {
//            Subject subject = SecurityUtils.getSubject();
//            subject.checkPermission("update");
            Integer result = feedBackService.updateFeedBack(id);
            if (result!=null&&result!=0){
                return Response.success(200,URLEncoder.encode("更新成功!"));
            }else {
                return Response.success(500,URLEncoder.encode("更新失败!"));
            }
        }catch (Exception e){
            return Response.error(300,URLEncoder.encode("无权限!"));
        }
    }

}
