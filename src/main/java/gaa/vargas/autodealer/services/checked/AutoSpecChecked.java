/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.checked;

 import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.domain.SpecChecked;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AutoSpecChecked {
     public List<SpecChecked> findSpecChecked(List<Spec> allSpec,List<Spec> selectSpec);

}
