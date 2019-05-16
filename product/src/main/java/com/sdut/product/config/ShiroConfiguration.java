package com.sdut.product.config;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.sdut.product.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lenovo on  三月
 */
@Configuration
public class ShiroConfiguration {

    @Value("${spring.datasource.redis.host}")
    private String host;
    @Value("${spring.datasource.redis.port}")
    private int port;
    @Value("${spring.datasource.redis.timeout}")
    private int timeout;
    @Value("${spring.datasource.redis.password}")
    private String password;


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //默认跳转到登陆页面
//        shiroFilterFactoryBean.setLoginUrl("/login");
        //登陆成功后的页面
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //自定义过滤器
        Map<String,Filter> filterMap=new LinkedHashMap<>();
        shiroFilterFactoryBean.setFilters(filterMap);
        //权限控制map
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout", "logout");
//        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
//        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 核心的安全事务管理器
     * 设置realm、cacheManager等
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager ();
        //设置realm
        securityManager.setRealm( myShiroRealm() );
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }


    /**
     * 身份认证Realm，此处的注入不可以缺少。否则会在UserRealm中注入对象会报空指针.
     * @return
     */
    @Bean
    public UserRealm myShiroRealm(  ){
        UserRealm myShiroRealm = new UserRealm();
        myShiroRealm.setCredentialsMatcher(  hashedCredentialsMatcher() );
        return myShiroRealm;
    }

    /**
     * 配置自定义的密码比较器
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        return  new CredentialsMatcher();
    }


    /**
     * 哈希密码比较器。在myShiroRealm中作用参数使用
     * 登陆时会比较用户输入的密码，跟数据库密码配合盐值salt解密后是否一致。
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用md5算法;
        hashedCredentialsMatcher.setHashIterations(1);//散列的次数，比如散列两次，相当于 md5( md5(""));
        return hashedCredentialsMatcher;
    }

    /**
     *  shiro缓存管理器;
     * 需要注入对应的其它的实体类中: 安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return
     */
//    @Bean
//    public EhCacheManager ehCacheManager(){
//        EhCacheManager cacheManager=new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
//        return cacheManager;
//    }

    /**
     * 记住我管理器
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥  默认AES算法
//         cookieRememberMeManager.setCipherKey();
        return  cookieRememberMeManager;
    }

    /**
     * cookie对象
     * @return
     */
    @Bean
    public Cookie rememberMeCookie() {
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        //记住我cookie生效时间，单位秒
        simpleCookie.setMaxAge(360000000);
        return simpleCookie;
    }


    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;否则@RequiresRoles等注解无法生效
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Shiro生命周期处理器
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 自动创建代理
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }



    /**
     * @Author yinyuchen
     * @Description //TODO
     * @Param []
     **/

    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        return mySessionManager;
    }

    public class MySessionManager extends DefaultWebSessionManager {
        @Override
        protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
            HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
            String token = httpServletRequest.getHeader("token");
//            System.out.println("token：" + token);
            if (!StringUtils.isEmpty(token)) {
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "token");
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
                return token;

            } else {
                return super.getSessionId(request, response);
            }
//            if(CookieUtil.get(httpServletRequest,"JSESSIONID") != null){
//                System.out.println(CookieUtil.get(httpServletRequest,"JSESSIONID").getValue());
//            }
        }
    }
}
