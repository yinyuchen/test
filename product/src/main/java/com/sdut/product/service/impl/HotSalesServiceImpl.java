package com.sdut.product.service.impl;

import com.sdut.product.pojo.HotSales;
import com.sdut.product.dao.HotSalesMapper;
import com.sdut.product.service.HotSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author yinyuchen
 * @Description //TODO
 * @Date 10:57 2019/4/15
 * @Param
 * @return
 **/

@Service
public class HotSalesServiceImpl implements HotSalesService {

    @Autowired
    HotSalesMapper hotSalesMapper;


    @Override
    public Set<String> findHotSalesIdByProductId(String productId) {
        return hotSalesMapper.findHotSalesIdByProductId(productId);
    }

    @Override
    public HotSales findHotSalesByHotSalesId(String hotSalesId) {
        return hotSalesMapper.findHotSalesByHotSalesId(hotSalesId);
    }
}
