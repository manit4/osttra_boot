package com.osttra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.osttra.service.CustomUserDetailsService;
import com.osttra.to.CustomUserDetails;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JWTAuthenticationFilter jwtAuthenticationFilter;
	

	
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("inside first configurer...");
		http
			.csrf().disable()
				.authorizeHttpRequests()
				.antMatchers("/token").permitAll()
					.anyRequest()
						.authenticated()
							.and()
								.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("inside second configurer...1");

//		auth.inMemoryAuthentication().withUser("Rishika").password(this.passwordEncoder().encode("123")).roles("Admin");
//		auth.inMemoryAuthentication().withUser("Parv").password(this.passwordEncoder().encode("234")).roles("Student");
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());

	}
	
//	@Bean
//	public NoOpPasswordEncoder passwordEncoder() {
//		
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		System.out.println("inside Bcrypt password Encoder...");
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
//	public BCryptPasswordEncoder passwordEncoder() {
//		
//		System.out.println("isndie Bcrypt...");
//		
//		return new BCryptPasswordEncoder();
//	}

}




//String suhailPasswordEncoded = this.passwordEncoder().encode("Ali");
//System.out.println("suhailPasswordEncoded " + suhailPasswordEncoded);
//
//String shaliniEncodedPassword = this.passwordEncoder().encode("Singh");
//System.out.println("shaliniEncodedPassword "+shaliniEncodedPassword);

//auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
//System.out.println("inside configurer...2");


//<------------------------

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
////	protected void configure(HttpSecurity http) throws Exception {
////		System.out.println("isnide first configurer...");
////		http
////			.authorizeHttpRequests()
//////				.antMatchers("/home", "/welcome").permitAll()
//////					.antMatchers("/registration_page").hasRole("Admin")
////			.antMatchers("/user/**").permitAll()
////			
////					.anyRequest()
////						.authenticated()
////							.and()
////								.httpBasic();
////	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("inside first configurer...");
//		http
//			.csrf().disable()
//				.authorizeHttpRequests()
//				.antMatchers("/signin", "/registration_page", "/register").permitAll()
//					.anyRequest()
//						.authenticated()
//							.and()
//								.formLogin()
//									.loginPage("/signin")
//										.loginProcessingUrl("/dologin")
//											.defaultSuccessUrl("/welcomePage", true);
//	}
//	
//	
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("inside second configurer...1");
//
////		auth.inMemoryAuthentication().withUser("Rishika").password(this.passwordEncoder().encode("123")).roles("Admin");
////		auth.inMemoryAuthentication().withUser("Parv").password(this.passwordEncoder().encode("234")).roles("Student");
//		
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
//
//	}
//	
////	@Bean
////	public NoOpPasswordEncoder passwordEncoder() {
////		
////		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
////	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		
//		System.out.println("inside Bcrypt password Encoder...");
//		
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//	
////	public BCryptPasswordEncoder passwordEncoder() {
////		
////		System.out.println("isndie Bcrypt...");
////		
////		return new BCryptPasswordEncoder();
////	}
//
//}
//
//
//
//
////String suhailPasswordEncoded = this.passwordEncoder().encode("Ali");
////System.out.println("suhailPasswordEncoded " + suhailPasswordEncoded);
////
////String shaliniEncodedPassword = this.passwordEncoder().encode("Singh");
////System.out.println("shaliniEncodedPassword "+shaliniEncodedPassword);
//
////auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
////System.out.println("inside configurer...2");


