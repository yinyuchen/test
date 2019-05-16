package com.sdut.product.service.impl;

import com.sdut.product.dao.SalesMapper;
import com.sdut.product.pojo.Sales;
import com.sdut.product.service.SalesService;
import com.sdut.product.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LogisticServiceImpl
 * @Discription  物流信息
 * @Author YinYuchen
 * @Date 2019/5/7 20:36
 **/
@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesMapper salesMapper;

    @Override
    public List<Object> selectSalesAll(String str) {
        Integer total = salesMapper.selectSalesCount(str);
        List<Sales> logisticList = salesMapper.selectSalesAll(str);
        List<Object> list = new ArrayList<>();
        for (Sales sales : logisticList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", sales.getId());
            map.put("productId", sales.getProductId());
            map.put("productName", sales.getProductName());
            map.put("website", sales.getWebsite());
            map.put("address", sales.getAddress());
            if (!StringUtils.isEmpty(sales.getTime())){
                sales.setTime(DateUtils.stampToDate(sales.getTime()));
            }
            map.put("time",sales.getTime());
            map.put("saler", sales.getSaler());
            map.put("total",total);
            list.add(map);
        }
        return list;
    }
}
