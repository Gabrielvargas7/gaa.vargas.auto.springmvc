/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

import java.util.List;

/**
 *
 * @author gabriel
 */
public class AutoWithPictures extends Auto
{
    private List<String> pictures;
    private String mainpicture;
    
    public AutoWithPictures() {
    }
    
    public String getMainpicture() {
		return mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}


	public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    
    public void setAuto(Auto auto)
    {
        this.setAutoid(auto.getAutoid());
        this.setBegindate(auto.getBegindate());
        this.setBrand(auto.getBrand());
        this.setCreateddate(auto.getCreateddate());
        this.setEnabled(auto.getEnabled());
        this.setEnddate(auto.getEnddate());
        this.setMiles(auto.getMiles());
        this.setModel(auto.getModel());
        this.setPrice(auto.getPrice());
        this.setSold(auto.getSold());
        this.setUserid(auto.getUserid());
        this.setYear(auto.getYear());
    }
}
