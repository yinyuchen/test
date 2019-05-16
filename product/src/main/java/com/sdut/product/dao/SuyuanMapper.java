package com.sdut.product.dao;

import com.sdut.product.pojo.FeedBack;
import com.sdut.product.pojo.Logistic;
import com.sdut.product.pojo.Production;
import com.sdut.product.pojo.Sales;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName InfoMapper
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:20
 **/
@Mapper
public interface SuyuanMapper {

    Production selectProductionById(String id);

    Logistic selectLogisticById(String id);

    Sales selectSalesById(String id);

    int insertFeedBack(FeedBack feedBack);
}
