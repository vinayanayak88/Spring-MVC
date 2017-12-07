/**
 * 
 */
package com.spring.mvc.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.persistence.model.LeaveEntity;
import com.spring.mvc.service.LeaveManagementService;
import com.spring.mvc.util.RestResponse;
import com.spring.mvc.util.ServiceUtils;
import com.spring.mvc.utils.constants.Constants;
import com.spring.mvc.vo.LeaveDetailsVo;

/**
 * @author Vinaya Nayak
 * Jul 24, 2017
 * LeaveManagementController.java
 */
@Controller
@RestController
public class LeaveManagementController {
	
	@Autowired
	LeaveManagementService leaveManagementService;
	
	@RequestMapping(value = "/applyleave", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RestResponse> applyleave(HttpServletRequest request, @RequestBody LeaveDetailsVo leaveDetailsVo) throws ParseException, Exception {
		System.out.println(LeaveManagementController.class + " : Inside apply leave");
		LeaveEntity entity = null ;
		RestResponse response = new RestResponse();
		try{
			 entity = leaveManagementService.processData(leaveDetailsVo);
		}
		catch(DataIntegrityViolationException de){
			System.out.println(LeaveManagementController.class + " : DataIntegrityViolationException in processing the data : " + de.getMessage());
		}
		catch(Exception e){
			System.out.println(LeaveManagementController.class + " : Exception in processing the data : " + e.getStackTrace());
		}
		
		if(null != entity ){
			response.setStatusMessage(Constants.SAVED_SUCCESSFULLY);
		}
			return ServiceUtils.getResponseEntity(response);
	}

}
