package com.sdut.product.dao;

import com.sdut.product.pojo.Logistic;
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
public interface LogisticMapper {
    List<Logistic> selectLogisticAll(@Param(value = "str") String str);

    int selectLogisticCount(@Param(value = "str") String str);

    int insertLogistic(Logistic logistic);

    int updateLogistic(Logistic logistic);

    int deleteById(@Param(value = "id") String id);
}
