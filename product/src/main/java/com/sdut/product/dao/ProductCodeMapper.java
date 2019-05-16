package com.sdut.product.dao;

import com.sdut.product.pojo.ProductCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yinyuchen
 * @Description //TODO
 * @Date 10:49 2019/3/22
 * @Param
 * @return
 **/

@Mapper
public interface ProductCodeMapper {

    int insert(ProductCode record);

    int updateByPrimaryKey(ProductCode record);

    List<ProductCode> selectAll(@Param(value="str")String str);

    int selectCount(@Param(value="str")String str);

    int selectById(String id);

    int deleteByIds(@Param(value = "ids") String ids);

    int updateCode(@Param(value = "id") String id, @Param(value = "fileName") String fileName);

    int deleteByPrimaryKey(String id);
}
