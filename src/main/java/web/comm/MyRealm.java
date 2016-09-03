//package web.comm;
//
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import web.po.User;
//import web.service.UserService;
//import web.utils.passwordUtils.PasswordHelper;
//
///**
// * <p>User: liuhonger
// * <p>Date: 14-1-28
// * <p>Version: 1.0
// */
//public class MyRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
//
//
//
//    /**
//     *授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
//     * @param principals
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        Test username = (Test)principals.getPrimaryPrincipal();
//
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(userService.findRoles(username));
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));
//
//        return authorizationInfo;
//    }
//
//    /**
//     * 认证回调函数,登录时调用.
//     * @param token
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
//
//        Test username = (Test) token.getPrincipal();
//        Test password= new Test((char[]) token.getCredentials());
//
//        User user = userService.findByUsername(username);
//
//        if(user == null) {
//            throw new UnknownAccountException();//没找到帐号
//        }
//
//        if(!PasswordHelper.checkPasswd(user,password)){
//            throw new IncorrectCredentialsException();///密码错误
//        }
//
//        if(Constants.NO_LOCKED.equals(user.getLocked())) {
//            throw new LockedAccountException(); //帐号锁定
//        }
//
//        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user.getUserName(), //用户名
//                user.getPassword(), //密码
//                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
//                getName()  //realm name
//        );
//        return authenticationInfo;
//    }
//
//    @Override
//    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthorizationInfo(principals);
//    }
//
//    @Override
//    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthenticationInfo(principals);
//    }
//
//    @Override
//    public void clearCache(PrincipalCollection principals) {
//        super.clearCache(principals);
//    }
//
//    public void clearAllCachedAuthorizationInfo() {
//        getAuthorizationCache().clear();
//    }
//
//    public void clearAllCachedAuthenticationInfo() {
//        getAuthenticationCache().clear();
//    }
//
//    public void clearAllCache() {
//
//        clearAllCachedAuthenticationInfo();
//        clearAllCachedAuthorizationInfo();
//    }
//
//
//
//}
