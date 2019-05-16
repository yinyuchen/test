package com.sdut.product.service;


import com.sdut.product.pojo.User;
import com.sdut.product.pojo.UserRole;

import java.util.Map;
import java.util.Set;

/**
 * @Author yinyuchen
 * @Description //TODO
 * @Date 14:07 2019/3/11
 * @Param
 * @return
 **/

public interface LoginService {
    Map<String, Object> checkLogin(String username, String password);

    int updatePassword(String username, String password);

    String selectByName(String username);

    User findByName(String username);

    String findUserIdByName(String username);

    Set<UserRole> findRoleIdByUid(String userId);

    String findRoleByRoleId(String roleId);

    Set<String> findPermissionIdByRoleId(String roleId);

    String findPermissionById(String permissionId);
}
