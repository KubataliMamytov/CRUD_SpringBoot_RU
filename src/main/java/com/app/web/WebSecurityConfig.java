package com.app.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withUsername("Kuba")
                .password("$2a$10$/nyLk.JHZ3K7hMa5XIYoteNgBxmoQqdpPVQu4qsQ8w96m7xpsA.RS")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("admin")
                .password("$2a$10$/nyLk.JHZ3K7hMa5XIYoteNgBxmoQqdpPVQu4qsQ8w96m7xpsA.RS")
                .roles("ADMIN")
                .build();


        UserDetails user3 = User
                .withUsername("manager")
                .password("$2a$10$/nyLk.JHZ3K7hMa5XIYoteNgBxmoQqdpPVQu4qsQ8w96m7xpsA.RS")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/estudiantes/**").hasRole("ADMIN")
                .antMatchers("editar_estudiantes/**","/crear_estudiantes/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();

    }
}
