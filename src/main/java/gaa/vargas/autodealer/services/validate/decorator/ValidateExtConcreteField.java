package gaa.vargas.autodealer.services.validate.decorator;

public class ValidateExtConcreteField extends ValidateComponent {

	
	
	public ValidateExtConcreteField() {
	
		this.setWrapdecorators(" ConcreteField ");
	}
	
	
	public String validation(String value,ValidateMessage validateMessage) {
			
			String isEmptyNullOrWhitespace = validateMessage.getIs_empty_null_or_whitespace();
	        String isNotEmptyNullOrWhitespace = validateMessage.getPass_validation();
	     
	        if (value!=null) value = value.trim();
	        
	        if (value==null)
	        {
	        	
	        	return  isEmptyNullOrWhitespace;
	        }else if(value.isEmpty())
	        {
	        	return isEmptyNullOrWhitespace;
	        } else
	        {
	        	return isNotEmptyNullOrWhitespace;
	        }	
	
	}
	
	
	
}
