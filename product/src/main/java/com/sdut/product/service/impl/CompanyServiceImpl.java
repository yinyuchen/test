package com.sdut.product.service.impl;

import com.sdut.product.pojo.Company;
import com.sdut.product.dao.CompanyMapper;
import com.sdut.product.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName InfoServiceImpl
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/26 16:20
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<Object> selectCompanyAll(String str) {
        Integer total = companyMapper.selectCompanyCount(str);
        List<Company> companyList = companyMapper.selectCompanyAll(str);
        List<Object> list = new ArrayList<>();
        for (Company company:companyList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", company.getId());
            map.put("name", company.getName());
            map.put("phone", company.getPhone());
            map.put("fax", company.getFax());
            map.put("mail",company.getMail());
            map.put("website",company.getWebsite());
            map.put("address",company.getAddress());
            map.put("introduction",company.getIntroduction());
            map.put("picture",company.getPicture());
            map.put("total",total);
            list.add(map);
        }
        return list;
    }

    @Override
    public int insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    @Override
    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    @Override
    public int deleteById(String id) {
        return companyMapper.deleteById(id);
    }

    @Override
    public Company selectById(String id) {
        return companyMapper.selectById(id);
    }
}
