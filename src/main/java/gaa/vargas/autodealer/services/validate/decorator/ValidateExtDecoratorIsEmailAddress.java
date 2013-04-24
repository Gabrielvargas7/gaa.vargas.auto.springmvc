package gaa.vargas.autodealer.services.validate.decorator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class ValidateExtDecoratorIsEmailAddress extends ValidateExtDecorator {
	ValidateComponent validateComponent;
	
	
	
	public ValidateExtDecoratorIsEmailAddress(ValidateComponent validateComponent) {
		this.validateComponent = validateComponent;
	}


	public String getWrapdecorators() {
		return this.validateComponent.getWrapdecorators() + " EmailAddress ";
	}
	


	public String validation(String value,ValidateMessage validateMessage) {
		
		String isGood = validateComponent.validation(value, validateMessage);
		
		if (isGood.equals(validateMessage.getPass_validation()))
		{
	 	
		    	String isEmailAddress = validateMessage.getPass_validation();
		        String isNotEmailAddress= validateMessage.getIs_not_email_address();
		        
		        try
		         {
		             // this function (InternetAddress) only validate this kind of email
		             // name@q or name@1
		             InternetAddress tmpAddr = new InternetAddress(value);
		             tmpAddr.validate();
		             // validate after the @
		             // 1. after @, a least one character, no number
		             // 2. must have a period
		             // 3. after the dot, aleast two characters
		             int position = value.indexOf("@");
		             String afteremail = value.substring(position+1);
		             int a = afteremail.indexOf(".");
		             // check if the length is grater than 3 and dot is not in the last position
		             
		             if (afteremail.length()<3)
		             {
		                 return isNotEmailAddress;
		                 
		             }else
		             {

		                if ((a ==-1)||  // check the dot exist
		                     ((a==0)&& // is on the first position
		                     (a!=afteremail.length()-1) // is on the last position
		                     ))
		                 {
		                     return isNotEmailAddress;
		                 }else
		                 {
		                     String beforedot = afteremail.substring(0,a);
		                     
		                     if (this.isAlphanumericWithUnderScore(beforedot))
		                     {
		                         String afterdot = afteremail.substring(a+1);

		                         if (this.isAlphanumericWithUnderScore(afterdot))
		                         {
		                             return isEmailAddress;
		                         }else
		                         {
		                             return isNotEmailAddress;
		                         }
		                     }else
		                     {
		                         return isNotEmailAddress;
		                     }
		                 }
		             }

		         }
		         catch (AddressException ex){
		             return isNotEmailAddress;
		       }        
		}
		return isGood;
		
	}
	  
	private boolean isAlphanumericWithUnderScore(String value)
	{
		
		   boolean isAlphanumeric = true;
	       boolean isNotAlphanumeric = false;
	    
	        for (int i = 0; i < value.length(); i++)
	        {
	            if (!Character.isLetterOrDigit(value.charAt(i)))
	            {
	                    return isNotAlphanumeric;
	            }
	        }
	       return isAlphanumeric;

	}
	

}
