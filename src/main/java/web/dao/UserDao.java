package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.po.User;

import java.util.List;
import java.util.Set;

/**
 * Created by liuhonger on 2016/3/29.
 */
@Repository
public interface UserDao {
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    public  User findOne(Long userId);

    public  User findByUsername(String username);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);
}
