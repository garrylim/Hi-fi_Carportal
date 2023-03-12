package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Service.userDetailServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new userDetailServiceImp();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(userDetailsService());
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http
		
		.authorizeHttpRequests()
            .antMatchers(HttpMethod.GET, "/").permitAll()
            .antMatchers(HttpMethod.GET, "/assets/**").permitAll()
            .antMatchers(HttpMethod.GET, "/dashboard").hasAnyAuthority("USER", "ADMIN")
            .antMatchers(HttpMethod.GET, "/storeList").hasAnyAuthority("ADMIN")
            .antMatchers(HttpMethod.GET, "/messagePage").permitAll()
            .antMatchers(HttpMethod.POST, "/process_signup").permitAll()
            .antMatchers(HttpMethod.POST, "/messagePage").permitAll()
			.antMatchers(HttpMethod.GET, "/profile").permitAll()
			.antMatchers(HttpMethod.GET, "/update-profile").permitAll()
			.antMatchers(HttpMethod.POST, "/update-profile").permitAll()
			.antMatchers(HttpMethod.GET, "/cars").hasAnyAuthority("USER","ADMIN")
			.antMatchers(HttpMethod.GET, "/car_detail").hasAnyAuthority("USER","ADMIN")
			.antMatchers(HttpMethod.GET, "/search").hasAnyAuthority("USER","ADMIN")
			.antMatchers(HttpMethod.GET,"/new_car").hasAuthority("USER")
			.antMatchers(HttpMethod.POST, "/cars").hasAnyAuthority("USER","ADMIN")
			.antMatchers(HttpMethod.GET,"/edit").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/cars").hasAnyAuthority("USER","ADMIN")
			.antMatchers(HttpMethod.GET, "/delete").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/delete").hasAuthority("ADMIN")

            .anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/login")
			.usernameParameter("email")
			.defaultSuccessUrl("/dashboard")
			.permitAll()
			.and()
			.logout() // add this to configure logout behavior
            .logoutUrl("/logout") // URL to trigger logout
            .logoutSuccessUrl("/") // URL to redirect after logout
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .permitAll(); // allow all users to access the logout URL
		
		return http.build();
		
	}

}