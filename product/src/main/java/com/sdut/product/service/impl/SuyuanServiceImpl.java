package com.sdut.product.service.impl;

import com.sdut.product.pojo.FeedBack;
import com.sdut.product.pojo.Logistic;
import com.sdut.product.pojo.Production;
import com.sdut.product.pojo.Sales;
import com.sdut.product.dao.SuyuanMapper;
import com.sdut.product.service.SuyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName InfoServiceImpl
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:20
 **/
@Service
public class SuyuanServiceImpl implements SuyuanService {

    @Autowired
    SuyuanMapper suyuanMapper;


    @Override
    public Production selectProductionById(String id) {
        Production production = suyuanMapper.selectProductionById(id);
        return production;
    }

    @Override
    public Logistic selectLogisticById(String id) {
        Logistic logistic = suyuanMapper.selectLogisticById(id);
        return logistic;
    }

    @Override
    public Sales selectSalesById(String id) {
        Sales sales = suyuanMapper.selectSalesById(id);
        return sales;
    }

    @Override
    public int insertFeeBack(FeedBack feedBack) {
        return suyuanMapper.insertFeedBack(feedBack);
    }
}
