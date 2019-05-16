package com.sdut.product.service.impl;

import com.sdut.product.dao.FeedBackMapper;
import com.sdut.product.pojo.FeedBack;
import com.sdut.product.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    FeedBackMapper feedBackMapper;

    @Override
    public List<Object> selectFeedBackAll(String str) {
        Integer total = feedBackMapper.selectFeedBackCount(str);
        List<FeedBack> feedBackList = feedBackMapper.selectFeedBackAll(str);
        List<Object> list = new ArrayList<>();
        for (FeedBack feedBack:feedBackList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", feedBack.getId());
            map.put("productId", feedBack.getProductId());
            map.put("productName", feedBack.getProductName());
            map.put("people", feedBack.getPeople());
            map.put("phone", feedBack.getPhone());
            map.put("problem", feedBack.getProblem());
            map.put("suggest", feedBack.getSuggest());
            map.put("status", feedBack.getStatus());
            map.put("total",total);
            list.add(map);
        }
        return list;
    }

    @Override
    public FeedBack selectFeedBackById(String id) {
        return feedBackMapper.selectFeedBackById(id);
    }

    @Override
    public int insertFeedBack(FeedBack feedBack) {
        return feedBackMapper.insertFeedBack(feedBack);
    }

    @Override
    public int updateFeedBack(String id) {
        return feedBackMapper.updateFeedBack(id);
    }

}
