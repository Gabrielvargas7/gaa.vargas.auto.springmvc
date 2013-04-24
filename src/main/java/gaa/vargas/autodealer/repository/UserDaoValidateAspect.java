/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

 
import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.services.validate.ValidateDbField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author gabriel
 */
@Aspect
public class UserDaoValidateAspect
{

    @Around("execution(* UserDao.findAllOrderBy(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {

        List list = Arrays.asList(joinPoint.getArgs());

        String fieldname = (String) list.get(0);
        
        
        ValidateDbField validateDbField = new ValidateDbField();
        validateDbField.validateFieldName(fieldname);
        List<Message> messages = validateDbField.getMessages(); 
        
        if (messages.size()!=0)
         {
            fieldname="userid";
         }else
         {
        	
        	 String fieldtest = fieldname;
        	 Class cls = Class.forName("gaa.vargas.autodealer.domain.User");
            
             Field fieldlist[] = cls.getDeclaredFields();
             
             for (int i = 0; i < fieldlist.length; i++) 
             {
                Field fld = fieldlist[i];
                
                if (fld.getName().equals(fieldtest))
                {
                	fieldname=fieldtest;
                	break;
                }else 
                {
                	 fieldname="userid";
                }
             }
        	 
        
         }
        

        Object[] object = new Object[]{fieldname};
        try
        {

           Object result = joinPoint.proceed(object);
           return result;

        }catch(IllegalArgumentException e)
        {
            throw e;
        }

    }




}
