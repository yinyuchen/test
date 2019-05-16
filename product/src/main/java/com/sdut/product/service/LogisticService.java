package com.sdut.product.service;

import com.sdut.product.pojo.Logistic;

import java.util.List;

public interface LogisticService {
    List<Object> selectLogisticAll(String str);

    int insertLogistic(Logistic logistic);

    int updateLogistic(Logistic logistic);

    int deleteById(String id);
}
