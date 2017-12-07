/**
 * 
 */
package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.spring.mvc.persistence.model.Account;
import com.spring.mvc.persistence.repository.AccountEntityRepository;
import com.spring.mvc.utils.security.AccountUser;
import com.spring.mvc.vo.AccountVo;

/**
 * @author Vinaya Nayak
 * Jun 12, 2017
 * UserService.java
 */
@Service
public class UserService {
	
	@Autowired
	private AccountEntityRepository accountEntityRepository;
	
//	@Autowired
//	private PasswordEncoder encoder;

	public void saveUser(Account account) {
		//account.setPassword(encoder.encode(account.getPassword()));
		Account acc = accountEntityRepository.save(account);
	}

	public Account lookupAccountEntity(String username) {
		List<Account> acctEntities = accountEntityRepository.findByUsername(username);
		if (acctEntities != null && !acctEntities.isEmpty()) {
			return acctEntities.get(0);
		} else {
			return null;
		}
	}

	public AccountUser createAccountUser(Account accountEntity, boolean isValid) {
		String username = accountEntity.getUsername();
		String pwd = isValid ? accountEntity.getPassword() : "";
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		// create account user
		AccountUser accountUser = new AccountUser(username, pwd, accountEntity, grantedAuths);
		return accountUser;
	}

	public List<AccountVo> getUsers() {
		List<Account> list = accountEntityRepository.findAll();
		List<AccountVo> accountList = list.stream().map(account -> getAccountVo(account)).collect(Collectors.toList());
		return accountList;
	}
	
	private AccountVo getAccountVo(Account acc){
		AccountVo vo = new AccountVo();
		vo.setFirstName(acc.getFirstName());
		vo.setLastName(acc.getLastName());
		vo.setEmail(acc.getEmail());
		return vo;
	}
}
