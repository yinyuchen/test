package com.sdut.product.controller;


import com.alibaba.fastjson.JSONObject;
import com.sdut.product.service.LoginService;
import com.sdut.product.util.JsonUtils;
import com.sdut.product.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Login
 * @Discription  /TODO 登陆
 * @Author yinyuchen
 * @Date 2019/3/11 9:34
 **/
@Api("登陆")
@RestController
@CrossOrigin
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    private LoginService loginService ;

    @ApiOperation("登陆方法")
    @RequestMapping(value="/login")
    public String login(@RequestParam(value = "username", required = false)String username, @RequestParam(value = "password", required = false)String password, Model model, HttpSession session){

        String sessionId = "";
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setTimeout(-1001);
        boolean flag = false;
        try {
            subject.login(token);
            sessionId = (String) subject.getSession().getId();
        }catch (Exception e){
            System.out.println("  subject.login(token)  error");
        }

        flag = subject.isAuthenticated();

        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> userMap = new HashMap<String, Object>();

        if (flag){
            userMap = loginService.checkLogin(username, MD5Util.encryptMD5(password));
            userMap.put("sessionId",sessionId);
            map.put("code",200);
            map.put("msg",URLEncoder.encode("成功"));
            map.put("user",userMap);
        }else {
            map.put("code",500);
            map.put("msg",URLEncoder.encode("账号密码错误"));
            map.put("user",userMap);
        }
        return JsonUtils.mapToJson(map);
    }

    @RequestMapping(value="/updatePassword")
    public int updateById(String username, String str){
        int result = 0;
        if (str!=null){
            JSONObject json = JSONObject.parseObject(str);
            String pwd = json.get("pwd")+"";
            Map<String, Object> userMap = loginService.checkLogin(username, MD5Util.encryptMD5(pwd));
            if (userMap!=null){
                String newpwd = json.get("newpwd")+"";
                String checknewpwd = json.get("checknewpwd")+"";
                if (newpwd.equals(checknewpwd)){
                    result = loginService.updatePassword(username, MD5Util.encryptMD5(newpwd));
                }else{
                    result=2;
                }
            }else {
                result = 3;
            }
        }
        return result;
    }


    @RequestMapping(value="/logout")
    public void userOut(){
        // 获取subject，判断是否已经认证，调用注销方法
        Subject subject = SecurityUtils.getSubject();
        System.out.println("logout-----"+subject.isAuthenticated());
        if (subject.isAuthenticated()) {
            try {
                subject.logout();
                System.out.println("用户退出！！！");
            }catch (Exception e){
                System.out.println("退出失败！！！");
            }
        }else {
            System.out.println("logout  error!!!");
        }
    }


}
