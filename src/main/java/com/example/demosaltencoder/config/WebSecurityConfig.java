package com.example.demosaltencoder.config;

import com.example.demosaltencoder.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Autowired
    private final UserDetailsService userDetailService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    public WebSecurityConfig(UserDetailsService userDetailService) {
        this.userDetailService = userDetailService;
    }

    public UserDetailsService userDetailService() {
        return userDetailService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                        registry.requestMatchers("/","/login","register").permitAll();
                        registry.requestMatchers("/authenticate").permitAll();
                        registry.anyRequest().authenticated();
                })
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                    jwtRequestFilter, UsernamePasswordAuthenticationFilter.class
                )
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
//        String salt = BCrypt.gensalt();
//        String encodedPassword = passwordEncoder.encode(password+salt);
//        Optional<MyUser> user = userRepo.findMyUserByName("khanh");
//        MyUser userObj = user.get();
//        String salt = userObj.getSalt();
        return new CustomPasswordEncoder();
//          return new BCryptPasswordEncoder();
    }

}
