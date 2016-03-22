package me.qisama.jxlx.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import me.qisama.jxlx.dao.ResourceMapper;
import me.qisama.jxlx.daoImpl.ResourceDaoImpl;
import me.qisama.jxlx.daoImpl.StudentDaoImpl;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;

public class StudentRealm extends AuthorizingRealm{
	
	@Autowired
	private ResourceDaoImpl resourceDaoImpl;
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		String username = (String)principals.getPrimaryPrincipal();
		Student student = studentDaoImpl.selectById(Long.valueOf(username));
		
		if (student != null) {
			Set<String> roles = new HashSet<String>();
			roles.add("家长");
			authorizationInfo.setRoles(roles);
			authorizationInfo.setStringPermissions(resourceDaoImpl.findPermissionsByRoleName("家长"));
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String)token.getPrincipal();

        Student student = studentDaoImpl.selectById(Long.valueOf(username));

        if(student == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		student.getUsername(), //用户名
        		student.getPassword(), //密码
                ByteSource.Util.bytes(student.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
	}

	@Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
