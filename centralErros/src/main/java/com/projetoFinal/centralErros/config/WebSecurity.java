package com.projetoFinal.centralErros.config;


import com.projetoFinal.centralErros.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import static com.projetoFinal.centralErros.config.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

  private static final String[] PUBLIC_MATCHERS_POST = {
          "/v1/user"
  };

  private static final String[] PUBLIC_MATCHERS_GET = {
          "/v1/user"
  };

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
  }

  @Override
  public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) {
    web.ignoring().antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST);
    web.ignoring().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET);
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic()
//            .and()
//            .csrf().disable();
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
            .and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/*/log/**").hasRole("USER")
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailsService));
  }

  @Bean
  public PasswordEncoder encoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}
