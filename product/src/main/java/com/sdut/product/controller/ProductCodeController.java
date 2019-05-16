package com.sdut.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdut.product.pojo.ProductCode;
import com.sdut.product.service.ProductCodeService;
import com.sdut.product.util.CodeUtil;
import com.sdut.product.util.UUIDUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.*;


/**
 * @Author yinyuchen
 * @Description //TODO  产品信息
 * @Date 10:58 2019/3/22
 * @Param
 * @return
 **/

@RestController
@CrossOrigin
@RequestMapping(value="/productCode")
public class ProductCodeController {

    @Autowired
    private ProductCodeService productService ;

    /**
     * @Author yinyuchen
     * @Description //TODO 溯源--获取所有商品二维码信息
     * @Date 14:21 2019/4/16
     * @Param [str]
     * @return java.lang.String
     **/

    @RequestMapping(value="/getProductCodeAll")
    public String getProductAll(String str){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("view");
            if (str!=null&&!str.equals("")){
                str="%"+str+"%";
            }
            int total = 0;
            total= productService.selectCount(str);
            List<ProductCode> ProductList  = productService.selectAll(str);
            List<Object> list = new ArrayList<>();
            if (ProductList !=null){
                for (ProductCode Product:ProductList) {
                    Map<String, Object> productMap = new HashMap<String, Object>();
                    productMap.put("id", Product.getId());
                    productMap.put("name", Product.getName());
                    productMap.put("code", Product.getCode());
                    list.add(productMap);
                }
                map.put("code",200);
                map.put("msg", URLEncoder.encode("查询成功"));
                map.put("product",list);
            }else {
                map.put("code",500);
                map.put("msg",URLEncoder.encode("查询失败"));
            }
            map.put("total",total);
        }catch (Exception e){
            map.put("code",300);
            map.put("msg",URLEncoder.encode("无权限!"));
        }
        Object json = JSONObject.toJSON(map);
        return json.toString();
    }


    /**
     * @Author yinyuchen
     * @Description //TODO 溯源 --- 获取二维码
     * @Date 14:23 2019/4/16
     * @Param [id]
     * @return int
     **/
    @RequestMapping(value = "/getCode")
    public int getCode(String id){

        String fileName = CodeUtil.createQrCode("http://123.56.28.192:8081/html/index.html?id="+id,"/imgs/", UUIDUtils.getId() +".jpg");

        int result = 0;
        result = productService.updateCode(id, "http://123.56.28.192:8081/imgs/"+fileName);

        return result;
    }

    /**
     * @Author yinyuchen
     * @Description //TODO 溯源--删除二维码信息
     * @Date 14:22 2019/4/16
     * @Param [id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "deleteById")
    public Map<String, Object> deleteById(String id){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("delete");
            result = productService.deleteByPrimaryKey(id);
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

    /**
     * @Author yinyuchen
     * @Description //TODO 溯源--二维码 更新
     * @Date 14:22 2019/4/16
     * @Param [str]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "updateById")
    public  Map<String, Object> updateById(String str){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("update");
            JSONObject json = JSONObject.parseObject(str);
            ProductCode product = new ProductCode();
            product.setId(json.get("id")+"");
            product.setName(json.get("name")+"");

        result = productService.updateByPrimaryKey(product);
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

    /**
     * @Author yinyuchen
     * @Description //TODO 溯源 --- 二维码插入
     * @Date 14:22 2019/4/16
     * @Param [str]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "insertCode")
    public Map<String, Object> insert(String str){
        int res = 0;
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("insert");
            JSONObject json = JSONObject.parseObject(str);
            ProductCode product = new ProductCode();
            product.setId(json.get("id")+"");
            product.setName(json.get("name")+"");


            res = productService.selectById(product.getId());
            if (res==0){
                result = productService.insert(product);
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


    /**
     * @Author yinyuchen
     * @Description //TODO 溯源 --二维码批量删除
     * @Date 14:22 2019/4/16
     * @Param [str]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "deleteByIds")
    public Map<String, Object> deleteByIds(String str){
        int result = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.checkPermission("delete");

            JSONObject json = JSONObject.parseObject(str);
            String ids = json.get("ids")+"";
            result = productService.deleteByIds(ids);
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

}
