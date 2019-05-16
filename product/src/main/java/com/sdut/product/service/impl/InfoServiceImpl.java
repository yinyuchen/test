package com.sdut.product.service.impl;

import com.sdut.product.pojo.Information;
import com.sdut.product.dao.InfoMapper;
import com.sdut.product.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
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
public class InfoServiceImpl implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    @Override
    public Information selectById(String id) {
        Information information = infoMapper.selectById(id);
        return information;
    }

    @Override
    public Map<String, Object> selectAll(String str) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Information> informationList  = infoMapper.selectAll(str);
        List<Object> list = new ArrayList<>();
        if (informationList !=null){
            for (Information information:informationList) {
                Map<String, Object> productMap = new HashMap<String, Object>();
                productMap.put("id", information.getId());
                productMap.put("name", information.getName());
                productMap.put("price", information.getPrice());
                productMap.put("weight", information.getWeight());
                productMap.put("material", information.getMaterial());
                productMap.put("brand", information.getBrand());
                productMap.put("place", information.getPlace());
                productMap.put("type", information.getType());
                productMap.put("standard", information.getStandard());
                productMap.put("licenseKey", information.getLicenseKey());
                productMap.put("keeping", information.getKeeping());
                productMap.put("productDate", information.getProductDate());
                productMap.put("qualityDate", information.getQualityDate());
                productMap.put("introduction", information.getIntroduction());
                productMap.put("picture", information.getPicture());

                list.add(productMap);
            }
            map.put("code",200);
            map.put("msg", URLEncoder.encode("查询成功"));
            map.put("product",list);
        }else {
            map.put("code",500);
            map.put("msg",URLEncoder.encode("查询失败"));
        }
        return map;
    }

    @Override
    public int selectCount(String str) {
        return infoMapper.selectCount(str);
    }
}
