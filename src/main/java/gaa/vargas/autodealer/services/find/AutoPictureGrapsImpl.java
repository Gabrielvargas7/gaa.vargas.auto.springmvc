/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.find;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.AutoWithPictures;
import gaa.vargas.autodealer.services.filter.AutoShowListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AutoPictureGrapsImpl
{
       private AutoPicture autoPicture;
       private String path;
       private AutoShowListImpl autosShow;
       private List<AutoWithPictures> autosWithPictures;


    public AutoPictureGrapsImpl(String path, List<Auto> autos) {

        this.autoPicture = new AutoPictureImpl();
        this.autosShow = new AutoShowListImpl();
        this.autosWithPictures = new ArrayList<AutoWithPictures>();
        this.path = path;
        this.setAutos(autos);
        autosShow.setNumbershowfrontend(10);
        autosShow.setEnabled(1);

    }

    public void setEnabled(int enabled)
    {
        autosShow.setEnabled(enabled);
    }

    public int getEnabled()
    {
        return autosShow.getEnabled();
    }


    public void setNumbershowfrontend(int numbershowfrontend) {
        autosShow.setNumbershowfrontend(numbershowfrontend);

    }

    public void setAutos(List<Auto> autos)
    {
        autosWithPictures = new ArrayList<AutoWithPictures>();
        
        Iterator iterator = autos.iterator();
        
        
      //  for (Auto auto: autos)
        while (iterator.hasNext())
        {
        	Auto auto = (Auto)iterator.next();
        	
            AutoWithPictures autoWithPicture = new AutoWithPictures();
            autoWithPicture.setAuto(auto);
            // add one pictures for each Auto
            List<String> pictures = new ArrayList<String>();

            String pic  = autoPicture.findMainPicture(autoWithPicture.getAutoid(),path);
            
            pictures.add(pic);

            autoWithPicture.setPictures(pictures);

            autosWithPictures.add(autoWithPicture);
        }
        autosShow.setAutos(autosWithPictures);
    }

    public List<AutoWithPictures> getNext()
    {
        return autosShow.getNext();
    }

    public List<AutoWithPictures> getPrevious()
    {
        return autosShow.getPrevious();
    }

    public void setLastvalue(int value)
    {
        this.autosShow.setLastvalue(value);
    }
    
    public void setStartValue(int value)
    {
    	this.autosShow.setStartValue(value);
    }

}
