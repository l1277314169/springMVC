package web.service.impl;

import web.po.User;
import web.service.UserService;

import java.util.Set;


/**
 * Created by Administrator on 2016-07-03.
 */
public class ssss implements UserService {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
