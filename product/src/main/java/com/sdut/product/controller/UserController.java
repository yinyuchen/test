package com.sdut.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdut.product.pojo.User;
import com.sdut.product.service.UserService;
import com.sdut.product.util.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Discription   /TODO 后台人员管理
 * @Author yinyuchen
 * @Date 2019/3/20 10:32
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @RequestMapping(value="/getUserAll")
    public String selectAll(String str){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            List<User> userList  = userService.selectAll(str);
            int total = 0;
            total= userService.selectCount(str);

            List<Object> list = new ArrayList<>();
            if (userList !=null){
                for (User user:userList) {
                    Map<String, Object> userMap = new HashMap<String, Object>();
                    userMap.put("id", user.getId());
                    userMap.put("username", user.getUsername());
                    userMap.put("sex", user.getSex());
                    userMap.put("name", user.getName());
                    userMap.put("avatar",user.getAvatar());
                    list.add(userMap);
                }
                map.put("code",200);
                map.put("msg",URLEncoder.encode("查询成功"));
                map.put("user",list);
            }else {
                map.put("code",500);
                map.put("msg",URLEncoder.encode("查询失败"));
            }
            map.put("total",total);
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return JsonUtils.mapToJson(map);
    }

    @RequestMapping(value="/updateById")
    public Map<String, Object> updateById(String str){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("update");
            JSONObject json = JSONObject.parseObject(str);
            User user = new User();
            user.setId(json.get("id") + "");
            user.setName(json.get("name") + "");
            user.setUsername(json.get("username") + "");
            user.setSex(Integer.valueOf(json.get("sex") + ""));
            result = userService.updateByPrimaryKey(user);

            if (result==0){
                map.put("code",500);
                map.put("msg",URLEncoder.encode("更新失败!"));
            }else {
                map.put("code",200);
                map.put("msg",URLEncoder.encode("更新成功!"));
            }
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return map;
    }

    @RequestMapping(value="/deleteById")
    public Map<String, Object> deleteById(String id){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("delete");
            result = userService.deleteByPrimaryKey(id);
            if (result==0){
                map.put("code",500);
                map.put("msg",URLEncoder.encode("删除失败!"));
            }else {
                map.put("code",200);
                map.put("msg",URLEncoder.encode("删除成功!"));
            }
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }

        return map;
    }

    @RequestMapping(value="/deleteByIds")
    public Map<String, Object> deleteByIds(String str){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("delete");
            JSONObject json = JSONObject.parseObject(str);
            String ids = json.get("ids")+"";
            result = userService.deleteByIds(ids);
            if (result==0){
                map.put("code",500);
                map.put("msg",URLEncoder.encode("删除失败!"));
            }else {
                map.put("code",200);
                map.put("msg",URLEncoder.encode("删除成功!"));
            }
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return map;
    }

    @RequestMapping(value="/insert")
    public Map<String, Object> insertSelective(String str){
        int res = 0;
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("insert");

            JSONObject json = JSONObject.parseObject(str);
            User user = new User();
            user.setName(json.get("name")+"");
            user.setUsername(json.get("username")+"");
            user.setSex(Integer.valueOf(json.get("sex")+""));

            if (user.getSex()==0){
                user.setAvatar("http://123.56.28.192:8081/imgs/girl.jpeg");
            }

            res = userService.selectByUsername(user.getUsername());
            if (res==0){
                result = userService.insertSelective(user);
            }

            if (result==0){
                map.put("code",500);
                map.put("msg",URLEncoder.encode("新增失败!"));
            }else {
                map.put("code",200);
                map.put("msg",URLEncoder.encode("新增成功!"));
            }
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        return map;
    }

}
