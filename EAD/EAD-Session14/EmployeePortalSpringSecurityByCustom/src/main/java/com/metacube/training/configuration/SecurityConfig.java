package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private CustomAuthentication authProvider;

    /**
     * Method for user authentication
     * 
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authProvider);
    }

    /**
     * Method for configuration of request
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/*")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/employee/*")
                .access("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/Login") // login configuration
                .usernameParameter("email").passwordParameter("password")
                .defaultSuccessUrl("/default").failureUrl("/login?error=true")
                .and().logout().logoutUrl("/Logout")// logout configuration
                .logoutSuccessUrl("/login");
    }
}