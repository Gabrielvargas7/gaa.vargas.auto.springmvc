/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.validate;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.services.validate.decorator.ValidateMessage;
import gaa.vargas.autodealer.services.validate.decorator.ValidateWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ValidateAuto
{

	private List<Message> messages;

    public ValidateAuto() {
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


	public void validateAutoAdd(Auto auto)
    {
		ValidateMessage validateMessage = new ValidateMessage();	
		ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
		validateMessage.setMax_length(30);
		validateMessage.setMin_length(0);
		validateWrapper.validateText(auto.getBrand(),"brand");
        validateWrapper.validateText(auto.getModel(),"model");
    }

    public void validateAutoDigits(String value,String name)
    {
    
    	ValidateMessage validateMessage = new ValidateMessage();	
		ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
		validateMessage.setMax_length(10);
		validateMessage.setMin_length(0);
		validateWrapper.validateDigits(value,name);
    }
   
    public void validateAutoDecimal(String value, String name)
    {
      	ValidateMessage validateMessage = new ValidateMessage();	
		ValidateWrapper validateWrapper = new ValidateWrapper(messages,validateMessage);
		validateMessage.setMax_length(7);
		validateMessage.setMin_length(0);
		validateWrapper.validateDecimal(value,name);
	 
    }



}
