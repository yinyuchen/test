package com.sdut.product.service;

import com.sdut.product.pojo.ProductCode;

import java.util.List;

/**
 * @ClassName ProductService
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/22 10:26
 **/
public interface ProductCodeService {

    List<ProductCode> selectAll(String str);

    int selectCount(String str);

    int updateCode(String id, String fileName);

    int updateByPrimaryKey(ProductCode product);

    int deleteByPrimaryKey(String id);

    int insert(ProductCode product);

    int selectById(String id);

    int deleteByIds(String ids);
}
