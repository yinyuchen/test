package com.sdut.product.dao;

import com.sdut.product.pojo.FeedBack;
import io.lettuce.core.dynamic.annotation.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FeedBackMapper {
    List<FeedBack> selectFeedBackAll(@Param(value = "str") String str);

    FeedBack selectFeedBackById(@Param(value = "id") String id);

    int selectFeedBackCount(@Param(value = "str") String str);

    int insertFeedBack(FeedBack feedBack);

    int updateFeedBack(@Param(value = "id") String id);
}
