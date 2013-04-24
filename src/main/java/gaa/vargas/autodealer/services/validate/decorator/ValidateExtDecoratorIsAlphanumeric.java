package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtDecoratorIsAlphanumeric extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	public ValidateExtDecoratorIsAlphanumeric(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}
	


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " Alphanumeric ";
	}

	
	
	public String validation(String value, ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value,validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
			   String isAlphanumeric = validateMessage.getPass_validation();
		       String isNotAlphanumeric = validateMessage.getIs_not_alphanumetic();
               for (int i = 0; i < value.length(); i++)
		        {
		            if (!Character.isLetterOrDigit(value.charAt(i)))
		            {
		                if(!Character.isWhitespace(value.charAt(i)))
		                {    
		    	        	return isNotAlphanumeric;		    		        
		                }
		            }
		        }
	        	return isAlphanumeric;		
		}
		return isGood;
		
	}

	

}
