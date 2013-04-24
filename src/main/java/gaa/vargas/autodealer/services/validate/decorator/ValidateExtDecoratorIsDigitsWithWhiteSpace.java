package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtDecoratorIsDigitsWithWhiteSpace extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsDigitsWithWhiteSpace(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " DigitsWithWhiteSpace ";
	}
	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value,validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
		    	String isDigits = validateMessage.getPass_validation();
		        String isNotDigits = validateMessage.getIs_not_numeric();
		            
		        for (int i = 0; i < value.length(); i++)
		        {
		                if (!Character.isDigit(value.charAt(i)))
		                {
		                   if(!Character.isWhitespace(value.charAt(i)))
		                        return isNotDigits;
		                }
		        }
		           return isDigits;
		}
		return isGood;
		
		
	}
	  
	

}
