package com.sdut.product.service.impl;

import com.sdut.product.pojo.User;
import com.sdut.product.pojo.UserRole;
import com.sdut.product.dao.LoginMapper;
import com.sdut.product.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LoginServiceImpl
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/11 14:07
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper ;

    @Override
    public Map<String,Object> checkLogin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User result =  loginMapper.selectByNameAndPwd(user);

        Map<String,Object> userMap = new HashMap<String, Object>();
        userMap.put("id", result.getId());
        userMap.put("username", result.getUsername());
        userMap.put("avatar", result.getAvatar());
        userMap.put("name", result.getName());

        return userMap;
    }

    @Override
    public int updatePassword(String username, String password) {
        int result = loginMapper.updatePassword(username, password);
        return result;
    }

    @Override
    public String selectByName(String username) {
        String password = loginMapper.selectByName(username);
        return password;
    }

    @Override
    public User findByName(String username) {
        User user = new User();

        User result =  loginMapper.findByName(username);

        return result;
    }

    @Override
    public String findUserIdByName(String username) {
        String userId = loginMapper.findUserIdByName(username);
        return userId;
    }

    @Override
    public Set<UserRole> findRoleIdByUid(String userId) {
        Set<UserRole> set = loginMapper.findRoleIdByUid(userId);
        return set;
    }

    @Override
    public String findRoleByRoleId(String roleId) {
        return loginMapper.findRoleByRoleId(roleId);
    }

    @Override
    public Set<String> findPermissionIdByRoleId(String roleId) {
        return loginMapper.findPermissionIdByRoleId(roleId);
    }

    @Override
    public String findPermissionById(String permissionId) {
        return loginMapper.findPermissionById(permissionId);
    }

}
