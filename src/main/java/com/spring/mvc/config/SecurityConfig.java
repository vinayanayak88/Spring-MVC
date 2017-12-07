/**
 * 
 */
package com.spring.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.spring.mvc.authentication.CustomAuthenticationProvider;

/**
 * @author Vinaya Nayak
 * Jun 10, 2017
 * SecurityConfig.java
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private CustomAuthenticationProvider authProvider;
	
//	@Autowired
//	@Qualifier("customUserDetailsService")
//	UserDetailsService userDetailsService;
	

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("vinaya")
//			.password("ammukins@123")
//			.authorities("ROLE_USER");
//	}
	
	 @Override
	    protected void configure(
	      AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authProvider);
	       // auth.userDetailsService(userDetailsService);
	    }
//	 
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	 
//	 @Bean
//	    public DaoAuthenticationProvider authenticationProvider() {
//	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//	       // authenticationProvider.setUserDetailsService(userDetailsService);
//	        authenticationProvider.setPasswordEncoder(passwordEncoder());
//	        return authenticationProvider;
//	    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/home").access("hasRole('ROLE_USER')").antMatchers("/**").permitAll().anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/landing").permitAll()
				.failureUrl("/login?error").permitAll()
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/login?logout").and().csrf().disable(); 
		
	}
	
}
