package com.metacube.training.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.Status.Status;
import com.metacube.training.models.EmployeeRole;
import com.metacube.training.services.EmployeeRolesService;
import com.metacube.training.services.EmployeeService;

/**
 * Class for Custom Authentication of User
 * 
 * @author Shubham Jain
 *
 */
@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRolesService employeeRolesService;

    /**
     * Method for custom authentication of user
     */
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String email = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        if (Status.NOT_FOUND.equals(employeeService.checkValidCredentials(
                email, password))) {
            throw new BadCredentialsException(
                    "External system authentication failed");
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<EmployeeRole> roleList = employeeRolesService
                .getRoleByEmail(email);

        for (EmployeeRole role : roleList) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new UsernamePasswordAuthenticationToken(email, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}