/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.configs;

import com.fatscompany.filters.CustomAccessDeniedHandler;
import com.fatscompany.filters.JwtAuthenticationTokenFilter;
import com.fatscompany.filters.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author khang
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.fatscompany.controllers",
    "com.fatscompany.repository",
    "com.fatscompany.service",
    "com.fatscompany.components"})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/api/**").permitAll();
        http.authorizeRequests().antMatchers("/api/login/").permitAll();
        http.authorizeRequests().antMatchers("/api/accounts/").permitAll();
        http.authorizeRequests().antMatchers("/api/days/").permitAll();
        http.authorizeRequests().antMatchers("/api/hocs/").permitAll();
        http.authorizeRequests().antMatchers("/api/StuHoc/").permitAll();
        http.authorizeRequests().antMatchers("/api/monhoc-giangvien/").permitAll();
        http.authorizeRequests().antMatchers("/api/monhocs/").permitAll();
        http.authorizeRequests().antMatchers("/api/monhocs/**").permitAll();
        http.authorizeRequests().antMatchers("/api/current-user/").permitAll();
        http.authorizeRequests().antMatchers("/api/current-detail-user/").permitAll();
        http.authorizeRequests().antMatchers("/api/sinhviens/").permitAll();
        http.authorizeRequests().antMatchers("/api/sinhviens/**").permitAll();
         http.authorizeRequests().antMatchers("/api/bangdiem/**").permitAll();
          http.authorizeRequests().antMatchers("/api/bangdiem/").permitAll();
         http.authorizeRequests().antMatchers("/api/studenScores/listscore").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/comments/").permitAll();
        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(",ADMIN",",TEACHER",",STUDENT")
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole(",ADMIN",",TEACHER",",STUDENT")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole(",ADMIN",",TEACHER",",STUDENT").and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
}
