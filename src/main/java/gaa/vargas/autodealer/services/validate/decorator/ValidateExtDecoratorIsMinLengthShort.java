package gaa.vargas.autodealer.services.validate.decorator;


public class ValidateExtDecoratorIsMinLengthShort extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsMinLengthShort(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " MinLengthShort ";
	}
	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value, validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
		    	String isMinLengthOk = validateMessage.getPass_validation();
		        String isMinLengthShort = validateMessage.getIs_min_length();
		        
		        if (validateMessage.getMin_length() >= value.length())
		        {
		             return isMinLengthShort;
		         }
		         return isMinLengthOk;
		
		}
		return isGood;
		
		
	}
	  
	

}
