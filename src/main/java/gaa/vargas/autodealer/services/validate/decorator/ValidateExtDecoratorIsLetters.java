package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtDecoratorIsLetters extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsLetters(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}



	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " Letters ";
	}

	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value,validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
		    	String isLetters = validateMessage.getPass_validation();
		        String isNotLetters = validateMessage.getIs_not_letters();

		        for (int i = 0; i < value.length(); i++)
		        {
		            if (!Character.isLetter(value.charAt(i)))
		            {
		                	return isNotLetters;		    		        
		            }
		        }
		    	return isLetters;		    		        

		    	

		}
		return isGood;
		
		
	}
	  
	

}
