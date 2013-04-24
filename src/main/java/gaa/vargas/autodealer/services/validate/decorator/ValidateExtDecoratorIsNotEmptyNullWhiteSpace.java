package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtDecoratorIsNotEmptyNullWhiteSpace extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsNotEmptyNullWhiteSpace(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}
	

	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " EmptyNullWhiteSpace ";
	}



	@Override
	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value,validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
			String isEmptyNullOrWhitespace = validateMessage.getIs_empty_null_or_whitespace();
	        String isNotEmptyNullOrWhitespace = validateMessage.getPass_validation();
	        if (value!=null) value = value.trim();
	        
	        if (value==null)
	        {
	        	return isEmptyNullOrWhitespace;
	        }else if(value.isEmpty())
	        {
	        	
	        	return isEmptyNullOrWhitespace;
	        } else
	        {
	        	return isNotEmptyNullOrWhitespace;
	        }
		
		}
		return isGood;
		
		
	}
	  
	

}
