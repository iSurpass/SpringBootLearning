package com.juniors.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Juniors
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的功能，效果，如果没有登录或权限就回来到默认 login 页面
        http.formLogin()
        .usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");

        //开启自动配置的注销功能
        http.logout().logoutUrl("/");
        //1、访问 /logout 表示用户注销，立即清空 session
        //2、注销成功会返回 /logout？logout

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
        //登录以后，将 cookie 发给浏览器保存一段时间，以后访问页面就会带上这个Cookie，
        //只要通过检查就可以免登录
        //点击注销会删除原有的 Cookie

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").roles("VIP1","VIP3")
//                .and()
//                .withUser("lisi").password("123456").roles("VIP2","VIP3")
//                .and()
//                .withUser("wangwu").password("123456").roles("VIP2");

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wangwu").password(
                new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3")
                .and()
                .withUser("venus").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3")
                .and()
                .withUser("juniors").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP1");
    }
}
