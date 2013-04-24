package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtDecoratorIsDecimal extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsDecimal(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " Decimal ";
	}
	
	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value,validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
		    	String isDecimal = validateMessage.getPass_validation();
		        String isNotDecimal = validateMessage.getIs_not_decimal();

		           for (int i = 0; i < value.length(); i++)
		           {
		               if (!Character.isDigit(value.charAt(i)))
		               {
		                    if (value.charAt(i) != '.')                   
		                       return isNotDecimal;
		               }
		           }
		          return isDecimal;
		}
		return isGood;
		
	}
	  
	

}
