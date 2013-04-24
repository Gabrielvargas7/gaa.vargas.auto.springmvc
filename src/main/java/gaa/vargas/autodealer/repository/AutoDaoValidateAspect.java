/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Message;
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
public class AutoDaoValidateAspect
{

    @Around("execution(* AutoDao.findAllOrderBy(..))")
    public Object findAllOrderBy(ProceedingJoinPoint joinPoint) throws Throwable
    {
        List list = Arrays.asList(joinPoint.getArgs());
        String fieldname = (String) list.get(0);
        
        ValidateDbField validateDbField = new ValidateDbField();
        validateDbField.validateFieldName(fieldname);
        List<Message> messages = validateDbField.getMessages(); 
          
        if (messages.size()!=0)
         {
            fieldname="autoid";
         }else
         {
         	
        	 String fieldtest = fieldname;
        	 Class cls = Class.forName("gaa.vargas.autodealer.domain.Auto");
            
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
                	 fieldname="autoid";
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

    @Around("execution(* AutoDao.findAllOrderByWithEnabled(..))")
    public Object findAllOrderByWithEnabled(ProceedingJoinPoint joinPoint) throws Throwable
    {

        List list = Arrays.asList(joinPoint.getArgs());

        String fieldname = (String) list.get(0);
        Object enabled =  list.get(1);

        ValidateDbField validateDbField = new ValidateDbField();
        validateDbField.validateFieldName(fieldname);
        List<Message> messages = validateDbField.getMessages(); 
          
        if (messages.size()!=0)
       
        {
            fieldname="autoid";
        }else
        {
        	
       	 String fieldtest = fieldname;
       	 Class cls = Class.forName("gaa.vargas.autodealer.domain.Auto");
           
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
               	 fieldname="autoid";
               }
            }
       	 
       
        }
       
        Object[] object = new Object[]{fieldname,enabled};
        try
        {
           Object result = joinPoint.proceed(object);
           return result;

        }catch(IllegalArgumentException e)
        {
            throw e;
        }
    }

    @Around("execution(* AutoDao.findAllOrderByWithEnabledAscDesc(..))")
    public Object findAllOrderByWithEnabledAscDesc(ProceedingJoinPoint joinPoint) throws Throwable
    {

        List list = Arrays.asList(joinPoint.getArgs());

        String fieldname = (String) list.get(0);
        Object enabled =  list.get(1);
        Object ascending_descending =  list.get(2);
        

        ValidateDbField validateDbField = new ValidateDbField();
        validateDbField.validateFieldName(fieldname);
        List<Message> messages = validateDbField.getMessages(); 
           
        if (messages.size()!=0)
      
        {
            fieldname="autoid";
        }else
        {
        	
       	 String fieldtest = fieldname;
       	 Class cls = Class.forName("gaa.vargas.autodealer.domain.Auto");
           
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
               	 fieldname="autoid";
               }
            }
       	 
       
        }
       
        Object[] object = new Object[]{fieldname,enabled,ascending_descending};
        try
        {
           Object result = joinPoint.proceed(object);
           return result;

        }catch(IllegalArgumentException e)
        {
            throw e;
        }
    }
    
    
    @Around("execution(* AutoDao.findByFilterOrderByWithEnabledAscDesc(..))")
    public Object findByFilterOrderByWithEnabledAscDesc(ProceedingJoinPoint joinPoint) throws Throwable
    {

        List list = Arrays.asList(joinPoint.getArgs());

        String fieldname = (String) list.get(0);
        Object enabled =  list.get(1);
        Object ascending_descending =  list.get(2);
        Object filterValue = list.get(3);
        

        ValidateDbField validateDbField = new ValidateDbField();
        validateDbField.validateFieldName(fieldname);
        List<Message> messages = validateDbField.getMessages(); 
          
        if (messages.size()!=0)
       
        {
            fieldname="autoid";
        }else
        {
        	
       	 String fieldtest = fieldname;
       	 Class cls = Class.forName("gaa.vargas.autodealer.domain.Auto");
           
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
               	 fieldname="autoid";
               }
            }
       	 
       
        }
        
        Object[] object = new Object[]{fieldname,enabled,ascending_descending,filterValue};
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
