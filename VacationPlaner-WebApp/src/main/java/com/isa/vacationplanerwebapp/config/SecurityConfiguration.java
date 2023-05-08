package com.isa.vacationplanerwebapp.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        logger.info("Configuring security filter chain");
        http.csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/home", "/index", "/css/*", "/assets/*", "/js/*", "/login/**").permitAll()
                .requestMatchers("/VacationList","/employeeList","/teamList","/vacationAdd").hasRole("USER")
                .requestMatchers("/vacationAdd","/vacationList","/vacationModify","/employeeAdd","/employeeModify","/teamModify","/teamAdd","/teamDelete","/vacationDelete","/employeeDelete").hasRole("SUPERUSER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().denyAll()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
            .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        logger.info("Creating user details service");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
            .password(bCryptPasswordEncoder().encode("userPass"))
            .roles("USER")
            .build());
        manager.createUser(User.withUsername("superuser")
            .password(bCryptPasswordEncoder().encode("superuserPass"))
            .roles("SUPERUSER", "USER")
            .build());
        manager.createUser(User.withUsername("admin")
            .password(bCryptPasswordEncoder().encode("adminPass"))
            .roles("ADMIN")
            .build());
        return manager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        logger.info("Creating BCrypt password encoder");
        return new BCryptPasswordEncoder();
    }

}
