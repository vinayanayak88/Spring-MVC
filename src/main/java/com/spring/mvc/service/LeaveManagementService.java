/**
 * 
 */
package com.spring.mvc.service;

import java.text.ParseException;

import com.spring.mvc.persistence.model.LeaveEntity;
import com.spring.mvc.vo.LeaveDetailsVo;

/**
 * @author Vinaya Nayak
 * Aug 1, 2017
 * LeaveManagementService.java
 */
public interface LeaveManagementService {
	
	public LeaveEntity processData(LeaveDetailsVo vo) throws ParseException;
	

}
