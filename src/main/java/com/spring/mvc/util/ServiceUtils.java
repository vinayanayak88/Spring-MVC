/**
 * 
 */
package com.spring.mvc.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author Vinaya Nayak
 * Aug 2, 2017
 * ServiceUtils.java
 */
public class ServiceUtils {
	
	public static ResponseEntity<RestResponse> getResponseEntity(RestResponse response) {
	    final HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<RestResponse>(response, httpHeaders, HttpStatus.OK);
	  }

}
