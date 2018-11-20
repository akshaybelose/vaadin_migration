/**
 * 
 */
package com.justransform.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justransform.model.User;
import com.justransform.service.LoginService;

/**
 * @author Akshay
 *
 */
@RestController
@RequestMapping("/api")
@Produces("application/json")
public class LoginController {

	@Autowired(required=true)
	LoginService loginService;
	
	@RequestMapping(value = "/getUser", method=RequestMethod.GET)
	public User getUser(@RequestParam(value = "username", required = false) String userName,
			@RequestParam(value = "password", required = false) String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
				System.out.println("In logincontroller");
				return loginService.login(userName, password);
				}
}
