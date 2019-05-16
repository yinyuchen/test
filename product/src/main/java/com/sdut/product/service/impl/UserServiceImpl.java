package com.sdut.product.service.impl;

import com.sdut.product.pojo.User;
import com.sdut.product.dao.UserMapper;
import com.sdut.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/20 10:33
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public List<User> selectAll(String str) {
        List<User> result =  userMapper.selectAll(str);

        return result;
    }

    @Override
    public int selectCount(String str) {
        int result = 0;
        result = userMapper.selectCount(str);

        return result;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        int result = 0;
        result = userMapper.updateByPrimaryKeySelective(user);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        int result = 0;
        result = userMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int insertSelective(User user) {
        int result = 0;
        result = userMapper.insertSelective(user);
        return result;
    }

    @Override
    public int selectByUsername(String username) {
        int result = 0;
        result = userMapper.selectByUsername(username);
        return result;
    }

    @Override
    public int deleteByIds(String ids) {
        int result = 0;
        result = userMapper.deleteByIds(ids);
        return result;
    }
}
