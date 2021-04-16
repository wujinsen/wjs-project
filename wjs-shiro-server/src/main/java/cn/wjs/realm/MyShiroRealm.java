package cn.wjs.realm;

import cn.wjs.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    /**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中,方便获取
     * 3、该方法可以直接使用CasRealm中的认证方法，此处仅用作测试
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

//        // 调用父类中的认证方法，CasRealm已经为我们实现了单点认证。
 //       AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
//
//        // 获取登录的账号，cas认证成功后，会将账号存起来
//        String account = (String) authc.getPrincipals().getPrimaryPrincipal();
//
//        // 将用户信息存入session中,方便程序获取,此处可以将根据登录账号查询出的用户信息放到session中
//        SecurityUtils.getSubject().getSession().setAttribute("no", account);
//
//        return authc;

        String userName = (String) token.getPrincipal();
        String userPwd = new String((char[]) token.getCredentials());
        //根据用户名从数据库获取密码
        String password = "123";
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password )) {
            throw new AccountException("密码不正确");
        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        return new SimpleAuthenticationInfo(user, password,getName());

    }

    /**
     * 此方法调用 hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权): 1、如果用户正常退出，缓存自动清空； 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。 （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例， 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取单点登陆后的用户名，也可以从session中获取，因为在认证成功后，已经将用户名放到session中去了
 //       String userName = (String) super.getAvailablePrincipal(principals);
//				principals.getPrimaryPrincipal(); 这种方式也可以获取用户名
        User user = (User)super.getAvailablePrincipal(principals);

        // 根据用户名获取该用户的角色和权限信息
//        UserInfo userInfo = userInfoService.findByUsername(userName);
//
//        // 将用户对应的角色和权限信息打包放到AuthorizationInfo中
//        for (SysRole role : userInfo.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("user:create");
        return authorizationInfo;

    }

}
