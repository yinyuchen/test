package com.sdut.product.dao;

import com.sdut.product.pojo.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName InfoMapper
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:20
 **/
@Mapper
public interface InfoMapper {
    Information selectById(String id);

    List<Information> selectAll(@Param(value="str")String str);

    int selectCount(@Param(value="str")String str);
}
