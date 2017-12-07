/**
 * 
 */
package com.spring.mvc.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.spring.mvc.persistence.model.Account;
import com.spring.mvc.service.UserService;
import com.spring.mvc.utils.security.AccountUser;

/**
 * Custom Spring authentication provider that authenticates against the account table.<br/><br/>
 * @author Vinaya Nayak Jun 11, 2017
 * CustomAuthenticationProvider.java
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService ;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		  UsernamePasswordAuthenticationToken authToken =
			        (UsernamePasswordAuthenticationToken) authentication;
			    String username = (String) authToken.getPrincipal();
			    String rawPassword = (String) authToken.getCredentials();
			    WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
			    Account accountEntity = userService.lookupAccountEntity(username);
			    boolean isValidPassword = validatePassword(accountEntity, rawPassword);
			    
			    UsernamePasswordAuthenticationToken token = null;
			    if (accountEntity != null) {
			    	 if (isValidPassword) {
			    		 token = handleValidPassword(accountEntity, details);
			    		 return token;
			    	 }
			    }
			    else{
			    	 token = handleInvalidUsername();
			    }
			    return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}
	
	private boolean validatePassword(Account accountEntity, String rawPassword) {
//	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	    return encoder.matches(rawPassword, accountEntity.getPassword());
		return rawPassword.equals(accountEntity.getPassword());
	  }
	
	private UsernamePasswordAuthenticationToken handleInvalidUsername() {
	    return null;
	  }
	
	 private UsernamePasswordAuthenticationToken handleValidPassword(Account accountEntity,
			 WebAuthenticationDetails details) throws AuthenticationException {
		    AccountUser acctUser = userService.createAccountUser(accountEntity, true);
		    UsernamePasswordAuthenticationToken token =
		        new UsernamePasswordAuthenticationToken(acctUser, accountEntity.getPassword(),
		            acctUser.getAuthorities());
		    token.setDetails(details);
		    SecurityContextHolder.getContext().setAuthentication(token);
		    return token;
		  }

	 
}
