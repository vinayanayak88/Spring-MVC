/**
 * 
 */
package com.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.spring.mvc.persistence.model.Account;
import com.spring.mvc.service.UserService;
import com.spring.mvc.vo.AccountVo;

/**
 * @author Vinaya Nayak
 * Jun 12, 2017
 * UserController.java
 */
@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUserForm(HttpServletRequest request) {
		return new ModelAndView("userform");
	}

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView landingForm(HttpServletRequest request) {
		return new ModelAndView("landing");
	}

	@RequestMapping(value = "/landing", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addUser(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");

		Account account = new Account();
		account.setUsername(userName);
		account.setPassword(password);
		account.setFirstName(fname);
		account.setLastName(lname);
		account.setPassword(password);
		account.setEmail(email);
		userService.saveUser(account);
		return new ModelAndView("landing");
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public String getUsers(HttpServletRequest request) {
		List<AccountVo> list = userService.getUsers();
		return new Gson().toJson(list);
	}

}
