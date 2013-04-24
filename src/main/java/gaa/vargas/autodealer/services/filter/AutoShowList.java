/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.filter;

import gaa.vargas.autodealer.domain.AutoWithPictures;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AutoShowList{
    public List<AutoWithPictures> getNext();
    public List<AutoWithPictures> getPrevious();
    public List<AutoWithPictures> getAutos();
    public void setStartValue(int value);
}
