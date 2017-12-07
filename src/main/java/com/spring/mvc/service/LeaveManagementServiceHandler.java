/**
 * 
 */
package com.spring.mvc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.persistence.model.LeaveEntity;
import com.spring.mvc.persistence.repository.LeaveManagementRepository;
import com.spring.mvc.utils.security.AccountUser;
import com.spring.mvc.vo.LeaveDetailsVo;

/**
 * @author Vinaya Nayak
 * Jul 26, 2017
 * LeaveManagementService.java
 */
@Service
public class LeaveManagementServiceHandler implements LeaveManagementService{
	
	protected Log log = LogFactory.getLog(getClass());
	
	@Autowired
	LeaveManagementRepository leaveManagementRepository;
	
	@Override
	@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public LeaveEntity processData(LeaveDetailsVo vo) throws ParseException{
		AccountUser user  = null ;
		LeaveEntity en = null;
		try{
			Authentication authentication =   SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && authentication.getPrincipal() instanceof AccountUser) {
				 user = (AccountUser) authentication.getPrincipal();
			}
			LeaveEntity entity = new LeaveEntity();
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
			Date startdate = simpleDateFormat.parse(vo.getStartdate());
			Date enddate = simpleDateFormat.parse(vo.getEnddate());
			entity.setStartDate(startdate);
			entity.setEndDate(enddate);
			entity.setLeaveType(vo.getLeaveType());
			entity.setReason(vo.getReason());
			entity.setAccount(user.getAccount());
			en = leaveManagementRepository.save(entity);
		}
		catch(Exception e){
			 log.error("Exception in date parsing: " + e.getMessage(), e);
		      e.printStackTrace();
		}
		return en;
	}
}
