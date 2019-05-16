package com.sdut.product.service;

import com.sdut.product.pojo.Information;

import java.util.Map;

/**
 * @ClassName InfoService
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:19
 **/
public interface InfoService {
    Information selectById(String id);

    Map<String, Object> selectAll(String str);

    int selectCount(String str);
}
