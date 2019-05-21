package com.sdut.product.service;

import com.sdut.product.pojo.Sales;

import java.util.List;

public interface SalesService {
    List<Object> selectSalesAll(String str);

    int insertSales(Sales sales);

    int updateSales(Sales sales);

    int deleteById(String id);
}
