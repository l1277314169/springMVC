package web.service.impl;

import org.apache.commons.collections.list.SetUniqueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.dao.UserDao;
import web.po.User;
import web.service.UserService;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    /**
     * 创建用户
     *
     * @param user
     */
    public User createUser(User user) {

        return userDao.createUser(user);
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);


        userDao.updateUser(user);
    }

    /**
     * 添加用户-角色关系
     *
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }


    /**
     * 移除用户-角色关系
     *
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long... roleIds) {


        userDao.uncorrelationRoles(userId, roleIds);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }

}
