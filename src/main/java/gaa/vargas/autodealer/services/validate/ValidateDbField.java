/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.validate;

import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.services.validate.decorator.ValidateMessage;
import gaa.vargas.autodealer.services.validate.decorator.ValidateWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ValidateDbField{
	

	private List<Message> messages;
	
	public ValidateDbField() {
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



    public void validateFieldName(String value)
    {

     	ValidateMessage validateMessage = new ValidateMessage();	
		ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
		
		validateMessage.setMax_length(30);
		validateMessage.setMin_length(0);
		validateWrapper.validateAlphanumeric(value, value);
	
    	
    }


}
