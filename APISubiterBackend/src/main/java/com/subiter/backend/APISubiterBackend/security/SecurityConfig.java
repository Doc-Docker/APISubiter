package com.subiter.backend.APISubiterBackend.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] PUBLIC_MATCHERS = {
            //"/h2-console/**"
    };

    private static final String[] PUBLIC_MATCHERS_GET = {

    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/api/usuarios/**",        // this will be used as "sign up" for now.
            "/auth/login/**",  // "sign in"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JWTAuthenticationFilter jWTAuthenticationFilter = new JWTAuthenticationFilter(authenticationManagerBean());
        jWTAuthenticationFilter.setFilterProcessesUrl("/auth/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll();
        http.authorizeRequests().antMatchers(GET, PUBLIC_MATCHERS_GET).permitAll();
        http.authorizeRequests().antMatchers(POST, PUBLIC_MATCHERS_POST).permitAll().anyRequest().authenticated();
        http.addFilter(jWTAuthenticationFilter);
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
        web.ignoring().antMatchers(POST, "/api/usuarios/auth/signup/suporte");
        web.ignoring().antMatchers(POST, "/api/usuarios/auth/signup/client");
        web.ignoring().antMatchers(GET, "/api/usuarios/auth/token/refresh");
    }

    public static Object authenticated() {
        try{
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }

}
