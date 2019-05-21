package com.sdut.product.dao;

import com.sdut.product.pojo.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yinyuchen
 * @Description //TODO
 * @Date 10:12 2019/3/28
 * @Param
 * @return
 **/

@Mapper
public interface SalesMapper {
    List<Sales> selectSalesAll(@Param(value = "str") String str);

    int selectSalesCount(@Param(value = "str") String str);

    int insertSales(Sales sales);

    int updateSales(Sales sales);

    int deleteById(@Param(value = "id") String id);
}
