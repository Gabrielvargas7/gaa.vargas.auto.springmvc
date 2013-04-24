/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.find;

 import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.AutoWithPictures;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AutoPictureGraps
{
    public void setEnabled(int enabled);
    public int getEnabled();
    public void setNumbershowfrontend(int numbershowfrontend);
    public void setAutos(List<Auto> autos);
    public List<AutoWithPictures> getNext();
    public List<AutoWithPictures> getPrevious();
    public void setLastvalue(int value);
    public void setStartValue(int value);
}
