/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.validate;

 import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.services.validate.decorator.ValidateMessage;
import gaa.vargas.autodealer.services.validate.decorator.ValidateWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ValidateUser
{

	private List<Message> messages;

	public ValidateUser() {
		this.messages = new ArrayList<Message>();
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void clearMessages()
	{
		this.messages.clear();
	}


	public void validateUserChange(User user,boolean passwordChange)
    {
    

		ValidateMessage validateMessage = new ValidateMessage();	
		ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
		
		validateMessage.setMax_length(30);
		validateMessage.setMin_length(0);
    	validateWrapper.validateText(user.getFirstname(),"firstname");
    	validateWrapper.validateText(user.getLastname() ,"lastname");
    	validateWrapper.validateText(user.getAddress(),"address");
    	validateWrapper.validateText(user.getCity(),"city");
    	validateWrapper.validateText(user.getState(),"state");
    	validateWrapper.validateText(user.getZip(),"zip");
    	validateMessage.setMax_length(10);
		validateMessage.setMin_length(0);
    
    	validateWrapper.validatePhone(user.getPhone1(),"cellphone");
    	validateWrapper.validatePhone(user.getPhone2(),"homephone");
    	validateMessage.setMax_length(50);
		validateMessage.setMin_length(5);
    
    	validateWrapper.validateEmailAddress(user.getUsername(),"email");

    	validateMessage.setMax_length(30);
		validateMessage.setMin_length(4);
    
        if (passwordChange) 
        	validateWrapper.validatePassword(user.getPassword(),"password");

    }


    public void validateUserAdd(User user)
    {

		ValidateMessage validateMessage = new ValidateMessage();	
    	ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
    	   
     	validateMessage.setMax_length(30);
		validateMessage.setMin_length(0);
    
    	validateWrapper.validateText(user.getFirstname(),"firstname");
    	validateWrapper.validateText(user.getLastname() ,"lastname");
    	validateWrapper.validateText(user.getAddress(),"address");
    	validateWrapper.validateText(user.getCity(),"city");
    	validateWrapper.validateText(user.getState(),"state");
    	validateWrapper.validateText(user.getZip(),"zip");
     	validateMessage.setMax_length(10);
		validateMessage.setMin_length(0);
    
    	validateWrapper.validatePhone(user.getPhone1(),"cellphone");
    	validateWrapper.validatePhone(user.getPhone2(),"homephone");
     	validateMessage.setMax_length(50);
		validateMessage.setMin_length(5);
    
    	validateWrapper.validateEmailAddress(user.getUsername(),"email");
     	validateMessage.setMax_length(30);
		validateMessage.setMin_length(4);
      	validateWrapper.validatePassword(user.getPassword(),"password");

    }

    public void validateUserPassword(String value)
    {
    	ValidateMessage validateMessage = new ValidateMessage();	
    	ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
     	validateMessage.setMax_length(30);
		validateMessage.setMin_length(4);
      	validateWrapper.validatePassword(value,"password");
    }
    
    public void validateNotNullorEmptyUserId(String value)
    {
    	ValidateMessage validateMessage = new ValidateMessage();	
    	ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
     	validateMessage.setMax_length(30);
		validateMessage.setMin_length(0);
      	validateWrapper.validateDigits(value,"user id");
    	
    }

    
}
