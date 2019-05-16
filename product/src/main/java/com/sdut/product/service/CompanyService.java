package com.sdut.product.service;

import com.sdut.product.pojo.Company;

import java.util.List;

/**
 * @ClassName InfoService
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:19
 **/
public interface CompanyService {
    List<Object> selectCompanyAll(String str);

    int insertCompany(Company company);

    int updateCompany(Company company);

    int deleteById(String id);

    Company selectById(String id);
}
