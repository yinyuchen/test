package com.sdut.product.service;

import com.sdut.product.pojo.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/20 10:33
 **/
public interface UserService {

    List<User> selectAll(String str);

    int selectCount(String str);

    int updateByPrimaryKey(User user);

    int deleteByPrimaryKey(String id);

    int insertSelective(User user);

    int selectByUsername(String username);

    int deleteByIds(String ids);
}
