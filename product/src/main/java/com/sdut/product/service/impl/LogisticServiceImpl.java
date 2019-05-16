package com.sdut.product.service.impl;

import com.sdut.product.dao.LogisticMapper;
import com.sdut.product.pojo.Logistic;
import com.sdut.product.service.LogisticService;
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
public class LogisticServiceImpl implements LogisticService {

    @Autowired
    LogisticMapper logisticMapper;

    @Override
    public List<Object> selectLogisticAll(String str) {
        Integer total = logisticMapper.selectLogisticCount(str);
        List<Logistic> logisticList = logisticMapper.selectLogisticAll(str);
        List<Object> list = new ArrayList<>();
        for (Logistic logistic : logisticList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", logistic.getId());
            map.put("productId", logistic.getProductId());
            map.put("productName", logistic.getProductName());
            map.put("name", logistic.getName());
            if (!StringUtils.isEmpty(logistic.getTime())){
                logistic.setTime(DateUtils.stampToDate(logistic.getTime()));
            }
            map.put("time", logistic.getTime());
            map.put("kuaidinum", logistic.getKuaidinum());
            map.put("total",total);
            list.add(map);
        }
        return list;
    }

    @Override
    public int insertLogistic(Logistic logistic) {
        return 0;
    }

    @Override
    public int updateLogistic(Logistic logistic) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
