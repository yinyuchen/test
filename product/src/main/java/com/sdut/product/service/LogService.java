package com.sdut.product.service;


import com.sdut.product.pojo.Logs;

import java.util.List;

public interface LogService {
    List<Object> selectLogAll(String str);

    int insertLog(Logs logs);
}
