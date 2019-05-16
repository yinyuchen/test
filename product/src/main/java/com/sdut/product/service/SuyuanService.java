package com.sdut.product.service;

import com.sdut.product.pojo.FeedBack;
import com.sdut.product.pojo.Logistic;
import com.sdut.product.pojo.Production;
import com.sdut.product.pojo.Sales;

/**
 * @ClassName InfoService
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:19
 **/
public interface SuyuanService {

    Production selectProductionById(String id);

    Logistic selectLogisticById(String id);

    Sales selectSalesById(String id);

    //插入建议反馈
    int insertFeeBack(FeedBack feedBack);
}
