package com.sdut.product.controller;

import com.sdut.product.pojo.FeedBack;
import com.sdut.product.pojo.Logistic;
import com.sdut.product.pojo.Production;
import com.sdut.product.pojo.Sales;
import com.sdut.product.service.SuyuanService;
import com.sdut.product.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName InfoController
 * @Discription    /TODO  溯源
 * @Author yinyuchen
 * @Date 2019/3/26 16:30
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/suyuan")
public class SuyuanController {

    @Autowired
    SuyuanService suyuanService;

    /**
     * @Author yinyuchen
     * @Description //TODO 溯源列表。根据id查询数据
     * @Date 16:17 2019/4/15
     * @Param [id]
     * @return java.lang.String
     **/

    @RequestMapping(value = "selectById")
    public String selectById(String id){
        Production production = suyuanService.selectProductionById(id);

        Logistic logistic = suyuanService.selectLogisticById(id);

        Sales sales = suyuanService.selectSalesById(id);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("productionTime",production.getTime());
        map.put("place",production.getPlace());
        map.put("status",production.getStatus());
        map.put("people",production.getPeople());
        map.put("picture",production.getPicture());
        map.put("video",production.getVideo());
        map.put("introduction",production.getIntroduction());

        map.put("name",logistic.getName());
        map.put("logisticTime",logistic.getTime());
        map.put("kuaidinum",logistic.getKuaidinum());

        map.put("website",sales.getWebsite());
        map.put("address",sales.getAddress());
        map.put("salesTime",sales.getTime());
        map.put("saler",sales.getSaler());

        return JsonUtils.mapToJson(map);
    }


    /**
     * @Author yinyuchen
     * @Description //TODO   建议反馈，插入操作
     * @Date 16:17 2019/4/15
     * @Param [id]
     * @return java.lang.String
     **/
    @RequestMapping(value = "insertFeedBack")
    @ResponseBody
    public int insertFeedBack(@RequestBody FeedBack feedBack){
        int result = 0;
        result = suyuanService.insertFeeBack(feedBack);
        return result;
    }

}
