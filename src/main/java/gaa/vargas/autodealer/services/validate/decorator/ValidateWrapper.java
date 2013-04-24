package gaa.vargas.autodealer.services.validate.decorator;

import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.services.validate.decorator.*;

import java.util.ArrayList;
import java.util.List;

public class ValidateWrapper {
		
		private List<Message> messages;
		private ValidateMessage validateMessage;
		
	
		public ValidateWrapper(List<Message> messages,
				ValidateMessage validateMessage) {
			this.messages = messages;
			this.validateMessage = validateMessage;
		}

		public List<Message> getMessages() {
			return messages;
		}

		public void setMessages(List<Message> messages) {
			this.messages = messages;
		}
		

		public ValidateMessage getValidateMessage() {
			return validateMessage;
		}

		public void setValidateMessage(ValidateMessage validateMessage) {
			this.validateMessage = validateMessage;
		}

		public void validateText(String value,String name)
	    {
	    	String message;
			ValidateComponent validateComponent = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateComponent = new ValidateExtDecoratorIsAlphanumericWithWhiteSpace(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMaxLengthOver(validateComponent);
			
			message = validateComponent.validation(value, validateMessage);
	        
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }

	    public void validateEmailAddress(String value,String name)
	    {
			String message;
			ValidateComponent validateComponent = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateComponent = new ValidateExtDecoratorIsMaxLengthOver(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMinLengthShort(validateComponent);
			validateComponent = new ValidateExtDecoratorIsEmailAddress(validateComponent);
			

			message = validateComponent.validation(value, validateMessage);


	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }

	    public void validatePassword(String value,String name)
	    {
	        
			String message;
			ValidateComponent validateComponent = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateComponent = new ValidateExtDecoratorIsAlphanumericWithWhiteSpace(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMaxLengthOver(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMinLengthShort(validateComponent);
			
			message = validateComponent.validation(value, validateMessage);

	    	
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }
	    
	    public void validatePhone(String value,String name)
	    {
	    	
			String message;
			ValidateComponent validateComponent = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateComponent = new ValidateExtDecoratorIsDigitsWithWhiteSpace(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMaxLengthOver(validateComponent);
			validateComponent = new ValidateExtDecoratorIsMinLengthShort(validateComponent);
			
			
			message = validateComponent.validation(value, validateMessage);
	    	
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }

	    public void validateDigits(String value,String name)
	    {
	    
			String message;
			ValidateComponent validateDigits = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateDigits = new ValidateExtDecoratorIsDigits(validateDigits);
			validateDigits = new ValidateExtDecoratorIsMaxLengthOver(validateDigits);
			
			message = validateDigits.validation(value, validateMessage);

	    	
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }
	

	    public void validateDecimal(String value,String name)
	    {
	    
	    	String message;
			ValidateComponent validateDecimal = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateDecimal = new ValidateExtDecoratorIsDecimal(validateDecimal);
			validateDecimal = new ValidateExtDecoratorIsMaxLengthOver(validateDecimal);
			message = validateDecimal.validation(value, validateMessage);
			
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }
	    
	    public void validateAlphanumeric(String value,String name)
	    {
	    	String message;
			ValidateComponent validateComponent = new ValidateExtConcreteField(); 
			// add decorator for the field
			validateComponent = new ValidateExtDecoratorIsAlphanumericWithWhiteSpace(validateComponent);
			message = validateComponent.validation(value, validateMessage);
	        
	        if(!message.equals(validateMessage.getPass_validation()))
	        {
	            Message mes = new Message();
	            mes.setName(name);
	            mes.setDescription(name+message);
	            messages.add(mes);
	        }
	    }

}
