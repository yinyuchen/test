package com.sdut.product.service.impl;

import com.sdut.product.pojo.Logs;
import com.sdut.product.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Discription
 * @Author YinYuchen
 * @Date 2019/5/20 15:51
 **/
@Service
public class LogServiceImpl implements LogService {

    @Override
    public List<Object> selectLogAll(String str) {
        return null;
    }

    @Override
    public int insertLog(Logs logs) {
        return 0;
    }
}
