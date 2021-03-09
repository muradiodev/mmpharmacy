//package com.mmpharmacy.mmpharmacy.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.firewall.DefaultHttpFirewall;
//import org.springframework.security.web.firewall.HttpFirewall;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
//        firewall.setAllowUrlEncodedSlash(true);
//        return firewall;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .and()
//
//                .authorizeRequests().antMatchers("/login", "/").permitAll()
//
//                .and()
//
//                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
//
//                .loginProcessingUrl("/doLogin")
//
//                .successForwardUrl("/postLogin")
//
//                .failureUrl("/loginFailed")
//
//                .and()
//
//                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
//
//                .and()
//
//                .rememberMe().tokenValiditySeconds(2592000).userDetailsService(this.userDetailsService())
//                .and()
//                .csrf().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        web
//                .httpFirewall(allowUrlEncodedSlashHttpFirewall())
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
//    }
//}