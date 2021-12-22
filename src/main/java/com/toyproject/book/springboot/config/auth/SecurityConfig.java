package com.toyproject.book.springboot.config.auth;

import com.toyproject.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/","/css/**","/imges/**","/js/**","/h2-console/**","/api/v1/**").permitAll()
                    // antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/api/v1/posts")    //수정 12/22 6:20
                .and()
                    .oauth2Login()
                        .redirectionEndpoint()
                            .baseUri("/oauth2/code/*")
                            .and()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
