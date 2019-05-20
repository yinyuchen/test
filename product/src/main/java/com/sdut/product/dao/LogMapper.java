package com.sdut.product.dao;

import com.sdut.product.pojo.Logs;
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
public interface LogMapper {
    List<Logs> selectLogAll(@Param(value = "str") String str);

    int selectLogCount(@Param(value = "str") String str);

    int insertLog(Logs logs);
}
