/**
 * 
 */
package com.spring.mvc.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.mvc.persistence.model.Account;

/**
 * @author Vinaya Nayak
 * Jun 11, 2017
 * AccountEntityRepository.java
 */
@Repository
public interface AccountEntityRepository extends BaseRepository<Account, Integer>{
	
	 
	 @Query("select a from Account a where a.username = (:username)")
	 List<Account> findByUsername(@Param("username") String username);

}
