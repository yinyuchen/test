package com.sdut.product.controller;

import com.sdut.product.pojo.HotSales;
import com.sdut.product.pojo.Information;
import com.sdut.product.service.HotSalesService;
import com.sdut.product.service.InfoService;
import com.sdut.product.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HotSalesController
 * @Discription
 * @Author yinyuchen
 * @Date 2019/4/15 11:57
 **/
@RestController
@CrossOrigin
@RequestMapping(value="/hot")
public class HotSalesController {
    @Autowired
    InfoService infoService;

    @Autowired
    HotSalesService hotSalesService;

    @RequestMapping(value = "selectById")
    public String selectById(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> hotSalesIdSet = new HashSet<>();
        Set<HotSales>  hotSales=new HashSet<>();
        Information information = infoService.selectById(id);
        map.put("picture", information.getPicture());

        hotSalesIdSet.addAll(hotSalesService.findHotSalesIdByProductId(id));

        for(String hotSalesId : hotSalesIdSet) {
            hotSales.add( hotSalesService.findHotSalesByHotSalesId( hotSalesId ));

        }
        map.put("hotSales", hotSales );
        return JsonUtils.mapToJson(map);
    }
}
