/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Auto
{
    private int autoid;
    private String brand;
    private String model;
    private int year;
    private double price;
    private Date createddate;
    private Date begindate;
    private Date enddate;
    private String sold;
    private int enabled;
    private int userid;
    private int miles;

    public Auto() {
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }


    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }



    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

  
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

 

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }
    
    
    public String getPriceCurrency()
    {
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
    	return nf.format(price);
    }
    
    public String getMilesFormat()
    {
      	NumberFormat nf = NumberFormat.getNumberInstance();
    	return nf.format(miles);
  
    }




}
