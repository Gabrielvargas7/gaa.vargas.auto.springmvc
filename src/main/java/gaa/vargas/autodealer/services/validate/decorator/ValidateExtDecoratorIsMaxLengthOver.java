package gaa.vargas.autodealer.services.validate.decorator;


public class ValidateExtDecoratorIsMaxLengthOver extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsMaxLengthOver(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " MaxLengthOver ";
	}

	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value, validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
		    	String isMaxLengthOk = validateMessage.getPass_validation();
		        String isMaxLengthOver = validateMessage.getIs_max_length();
		        
		        if (validateMessage.getMax_length() < value.length())
		        {
		             return isMaxLengthOver;
		         }
		         return isMaxLengthOk;
		
		}
		return isGood;
		
		
	}
	  
	

}
