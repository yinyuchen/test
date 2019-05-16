package com.sdut.product.service;

import com.sdut.product.pojo.FeedBack;

import java.util.List;

public interface FeedBackService {

    List<Object> selectFeedBackAll(String str);

    FeedBack selectFeedBackById(String id);

    int insertFeedBack(FeedBack feedBack);

    int updateFeedBack(String id);
}
