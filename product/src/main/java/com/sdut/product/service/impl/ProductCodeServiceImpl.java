package com.sdut.product.service.impl;

import com.sdut.product.pojo.ProductCode;
import com.sdut.product.dao.ProductCodeMapper;
import com.sdut.product.service.ProductCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/22 10:26
 **/
@Service
public class ProductCodeServiceImpl implements ProductCodeService {

    @Autowired
    ProductCodeMapper productMapper;

    @Override
    public List<ProductCode> selectAll(String str) {
        List<ProductCode> result =  productMapper.selectAll(str);

        return result;
    }

    @Override
    public int selectCount(String str) {
        int result = 0;
        result = productMapper.selectCount(str);

        return result;
    }

    @Override
    public int updateCode(String id, String fileName) {
        int result = 0;
        result = productMapper.updateCode(id, fileName);

        return result;
    }

    @Override
    public int updateByPrimaryKey(ProductCode product) {
        int result = 0;
        result = productMapper.updateByPrimaryKey(product);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        int result = 0;
        result = productMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int insert(ProductCode product) {
        int result = 0;
        result = productMapper.insert(product);
        return result;
    }

    @Override
    public int selectById(String id) {
        int result = 0;
        result = productMapper.selectById(id);
        return result;
    }

    @Override
    public int deleteByIds(String ids) {
        int result = 0;
        result = productMapper.deleteByIds(ids);
        return result;
    }
}
