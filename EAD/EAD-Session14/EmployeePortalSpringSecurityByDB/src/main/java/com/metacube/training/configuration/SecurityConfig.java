package com.metacube.training.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Security Config Class for User authentication by Database
 * 
 * @author Shubham Jain
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * Method for user authentication through database
     * 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery(
                        "select email,password,enabled from employee where email=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    /**
     * Method for configuration of request
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/*")
                .access("hasRole('ROLE_ADMIN')").antMatchers("/employee/*")
                .access("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/Login") // login configuration
                .usernameParameter("email").passwordParameter("password")
                .defaultSuccessUrl("/default").failureUrl("/login?error=true")
                .and().logout().logoutUrl("/Logout") // logout configuration
                .logoutSuccessUrl("/login");
    }
}