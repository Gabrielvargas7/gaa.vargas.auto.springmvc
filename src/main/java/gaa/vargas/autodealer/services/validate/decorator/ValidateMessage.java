/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.validate.decorator;

/**
 *
 * @author gabriel
 */
public class ValidateMessage {

    private int max_length;
    private int min_length;
    
//    private int min_length_email;
//    private int max_length_email;
//    private int min_length_phone;
//    private int max_length_phone;

    private String pass_validation;
    private String is_empty_null_or_whitespace;
    private String is_not_alphanumetic;
    private String is_not_numeric;
    private String is_not_email_address;
    
    private String is_max_length;
    private String is_min_length;
    
//    private String is_min_length_email;
//    private String is_max_length_email;
//    private String is_min_length_phone;
//    private String is_max_length_phone;
    private String is_not_decimal;
    private String is_not_letters;
    

    public ValidateMessage()
    {

         max_length = 30;
         min_length = 4;
//         min_length_email = 5;
//         max_length_email = 50;
//         min_length_phone = 10;
//         max_length_phone = 30;
//        
         pass_validation ="YES";
         is_empty_null_or_whitespace =" is required";
         is_not_alphanumetic  = " only alphanumeric characters";
         is_not_numeric  = " only numeric characters";
         is_max_length   = " is to long, Max length is "+max_length;
         is_min_length   = " is to short, Min length is "+min_length;
//         is_min_length_email  = " is to short, Min length is "+min_length_email;
//         is_max_length_email  = " is to long, Max length is "+max_length_email;
//     
         is_not_email_address = " is not a valid email address";

//         is_min_length_phone  = " is to short, Min length is "+min_length_phone;
//         is_max_length_phone  = " is to long, Max length is "+max_length_phone;
//    
         is_not_decimal       = " is not decimal";
         is_not_letters    = " only alphabetic characters";
    }
    
    

    public String getIs_not_letters() {
		return is_not_letters;
	}



	public void setIs_not_letters(String isNotLetters) {
		is_not_letters = isNotLetters;
	}



	public String getIs_not_decimal() {
        return is_not_decimal;
    }

    public void setIs_not_decimal(String is_not_decimal) {
        this.is_not_decimal = is_not_decimal;
    }

    public String getIs_empty_null_or_whitespace() {
        return is_empty_null_or_whitespace;
    }

    public void setIs_empty_null_or_whitespace(String is_empty_null_or_whitespace) {
        this.is_empty_null_or_whitespace = is_empty_null_or_whitespace;
    }

  
    public String getIs_not_alphanumetic() {
        return is_not_alphanumetic;
    }

    public void setIs_not_alphanumetic(String is_not_alphanumetic) {
        this.is_not_alphanumetic = is_not_alphanumetic;
    }

    public String getIs_not_email_address() {
        return is_not_email_address;
    }

    public void setIs_not_email_address(String is_not_email_address) {
        this.is_not_email_address = is_not_email_address;
    }

    public String getIs_not_numeric() {
        return is_not_numeric;
    }

    public void setIs_not_numeric(String is_not_numeric) {
        this.is_not_numeric = is_not_numeric;
    }

 
    public String getPass_validation() {
        return pass_validation;
    }

    public void setPass_validation(String pass_validation) {
        this.pass_validation = pass_validation;
    }



	public int getMax_length() {
		return max_length;
	}



	public void setMax_length(int maxLength) {
		max_length = maxLength;
	}



	public int getMin_length() {
		return min_length;
	}



	public void setMin_length(int minLength) {
		min_length = minLength;
	}



	public String getIs_max_length() {
		return is_max_length;
	}



	public void setIs_max_length(String isMaxLength) {
		is_max_length = isMaxLength;
	}



	public String getIs_min_length() {
		return is_min_length;
	}



	public void setIs_min_length(String isMinLength) {
		is_min_length = isMinLength;
	}
    







}
