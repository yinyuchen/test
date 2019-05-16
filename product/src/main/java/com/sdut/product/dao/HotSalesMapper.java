package com.sdut.product.dao;

import com.sdut.product.pojo.HotSales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @Author yinyuchen
 * @Description //TODO   热卖商品
 * @Date 10:41 2019/4/15
 * @Param 
 * @return 
 **/

@Mapper
public interface HotSalesMapper {
    Set<String> findHotSalesIdByProductId(@Param(value = "productId") String productId);

    HotSales findHotSalesByHotSalesId(@Param(value = "hotSalesId") String hotSalesId);
}
