/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.find;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AutoPicture {
    public String findMainPicture(int autoid, String path);
    public List<String> findAllPicture(int autoid, String path);
   

}
