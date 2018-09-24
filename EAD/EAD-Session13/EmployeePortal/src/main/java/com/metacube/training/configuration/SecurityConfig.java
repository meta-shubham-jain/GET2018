wpackage com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Method for user authentication
     * 
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("admin@gmail.com")
                .password("{noop}123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("employee@gmail.com")
                .password("{noop}123456").roles("EMPLOYEE");

    }

    /**
     * Method for configuration of request
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/*")
                .access("hasRole('ADMIN')").antMatchers("/employee/*")
                .access("hasRole('EMPLOYEE') or hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/Login")// login configuration
                .defaultSuccessUrl("/default").failureUrl("/login?error=true")
                .and().logout().logoutUrl("/Logout")// logout configuration
                .logoutSuccessUrl("/login");
    }
}