package com.justransform.application;

import org.springframework.stereotype.Service;

@Service
public class MessageBean { 
	
    public String login(String userName,String password) {
    	System.out.println("username "+userName);
    	
    	
        
    	return "Button was clicked by " + userName;
    }
}
