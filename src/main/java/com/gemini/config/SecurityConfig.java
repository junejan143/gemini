package com.gemini.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
    private UserDetailsService userDetailsService;
//    @Autowired
//    private IUserService userService;
    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;
    @Autowired
    private DaoAuthenticationProvider provider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
            protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
                Object salt = null;
                if (super.getSaltSource() != null) {
                    salt = super.getSaltSource().getSalt(userDetails);
                }
                if (authentication.getCredentials() == null) {
                    this.logger.debug("Authentication failed: no credentials provided");
                    throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
                } else {
                    String presentedPassword = authentication.getCredentials().toString();
                    if (!super.getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
                        //判断旧密码策略，若匹配成功，则修改为新策略
                        if (md5PasswordEncoder.isPasswordValid(userDetails.getPassword(), authentication.getCredentials().toString(), null)) {
//                            userService.updatePasswordByUserId(((User) userDetails).getUserId(), authentication.getCredentials().toString());
                        } else {
                            this.logger.debug("Authentication failed: password does not match stored value");
                            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
                        }
                    }
                }
            }
        };
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    Md5PasswordEncoder md5PasswordEncoder(){
        return new Md5PasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/user")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/dict/qusNote").hasAnyRole("HOSP_ADMIN","GROUP_ADMIN")
                .anyRequest().authenticated();
    }
}
