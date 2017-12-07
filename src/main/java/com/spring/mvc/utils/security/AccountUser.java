package com.spring.mvc.utils.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.spring.mvc.persistence.model.Account;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

public class AccountUser extends User {


	private Log log = LogFactory.getLog(getClass());

	// TODO: Would it be better to store a DTO or just top level attributes
	// rather than the actual entity?
	private Account account;

	private String timeZone;

	public String getTimeZone() {
		// added the below condition if Timezone is empty, set the default
		if (StringUtils.isEmpty(timeZone)) {
			return "UTC";
		} else {
			return timeZone;
		}
	}

	public void setTimeZone(String timeZone) {
		// added the below condition if Timezone is empty, set the default

		if (StringUtils.isEmpty(timeZone)) {
			try {
				log.info("User Timezone : " + timeZone);
				throw new Exception("Invalid TimeZone Format");
			} catch (Exception e) {
				log.error("Timezone Exception: " + e.getMessage(), e);

			} finally {
				this.timeZone = "UTC";
			}

		} else {
			this.timeZone = timeZone;
		}
	}

	public AccountUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public AccountUser(String username, String password, Account acct,
		      Collection<? extends GrantedAuthority> authorities) {
		    super(username, password, false, true, true, false, authorities);
		    this.setAccount(acct);
		  }


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	public String getName() {
		return getAccount() == null ? null : getAccount().getFirstName() + " " + getAccount().getLastName();
	}

	/**
	 * Convenience method to get the currently logged in user account. Returns
	 * null if one isn't found.
	 * 
	 * @return
	 */
	public static AccountUser getCurrent() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null && authentication.getPrincipal() instanceof AccountUser) {
				return (AccountUser) authentication.getPrincipal();
			}
		}
		return null;
	}
}
