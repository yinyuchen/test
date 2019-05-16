package com.sdut.product.service;

import com.sdut.product.pojo.HotSales;

import java.util.Set;

/**
 * @Author yinyuchen
 * @Description //TODO  热卖商品
 * @Date 10:41 2019/4/15
 * @Param 
 * @return 
 **/

public interface HotSalesService {

    Set<String> findHotSalesIdByProductId(String productId);

    HotSales findHotSalesByHotSalesId(String hotSalesId);
}
