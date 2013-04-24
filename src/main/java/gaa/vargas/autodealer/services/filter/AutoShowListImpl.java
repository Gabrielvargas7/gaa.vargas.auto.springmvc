/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.filter;

import gaa.vargas.autodealer.domain.AutoWithPictures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AutoShowListImpl implements AutoShowList
{
    private List<AutoWithPictures> autos;
    private int numbershowfrontend;
    private int enabled;
    private int lastvalue;
    private int initvalue;
    private static final int START_VALUE = 0;
    private static final int NUMBERS_SHOW =10;
    private static final int ENABLED = 1;


    public AutoShowListImpl() 
    {
     
    
        this.setStartValue(START_VALUE);
        
        this.setNumbershowfrontend(NUMBERS_SHOW);
        this.setEnabled(ENABLED);
    }

 
    public List<AutoWithPictures> getNext()
    {
        List<AutoWithPictures> next = new ArrayList<AutoWithPictures>();

        int size = this.getAutos().size();
        int last = 0;
        int init = 0;
        
        	
        if (size<=this.getLastvalue())
        {	
        	this.setLastvalue(size);
        	init = this.getInitvalue();
        	last = this.getLastvalue();
        }else 
        {
        	this.setInitvalue(this.getLastvalue());
            init = this.getInitvalue();
            last = this.getLastvalue()+this.getNumbershowfrontend();

        }
        if (last<=size)
        {
            next = this.getAutos().subList(init,last);
        	this.setLastvalue(last);
        	
        }
        else
        {
            next = this.getAutos().subList(init,size);
            this.setLastvalue(size);
            this.setInitvalue(init);
        }
            return next;
    }

   
    public List<AutoWithPictures> getPrevious()
    {
         List<AutoWithPictures> pre = new ArrayList<AutoWithPictures>();

      	int init = 0;
    	int last = 0;
        int size = this.getAutos().size();
    	
        if (size < this.getNumbershowfrontend())
        {
        	this.setInitvalue(0);
        	this.setLastvalue(size);
        }else 
        {	
	        if (size>this.getLastvalue())
	        {	
	        	if (this.getInitvalue()<this.getNumbershowfrontend())
	        	{
	        		this.setInitvalue(0);
	        	}else
	        	{	
	        		this.setInitvalue(this.getInitvalue()-this.getNumbershowfrontend());
	        	}
	        	
	        	this.setLastvalue(this.getLastvalue()-this.getNumbershowfrontend());
	        	
	        	if (this.getLastvalue()<this.getNumbershowfrontend())
	        	{
	        			this.setLastvalue(this.getNumbershowfrontend());
	        	}
	        	
	        }else 
	        {
	        	this.setLastvalue(this.getInitvalue());
	        	this.setInitvalue(this.getInitvalue()-this.getNumbershowfrontend());
	        	if (size<=this.getNumbershowfrontend())
	        	{
	        		this.setLastvalue(size);
	        	}
	        }
	        
        }
        
        init = this.getInitvalue();
        last = this.getLastvalue();
        
        pre = this.getAutos().subList(init,last);
        return pre;
    }

    public List<AutoWithPictures> getAutos() {
        return autos;
    }

    public void setAutos(List<AutoWithPictures> Autos)
    {

       
        this.autos = Autos;
    }



    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getLastvalue() {
        return lastvalue;
    }

    public void setLastvalue(int lastvalue) {
        this.lastvalue = lastvalue;
    }

    public int getNumbershowfrontend() {
        return numbershowfrontend;
    }

    public void setNumbershowfrontend(int numbershowfrontend) {
        this.numbershowfrontend = numbershowfrontend;
    
    }


	public int getInitvalue() {
		return initvalue;
	}


	public void setInitvalue(int initvalue) {
		this.initvalue = initvalue;
	}

    public void setStartValue(int value)
    {
    	this.setInitvalue(value);
    	this.setLastvalue(value);
    	
    }
    

 
 

}
