/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.checked;

 import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.AuthoritiesType;
import gaa.vargas.autodealer.domain.AuthoritiesTypeChecked;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AuthoritiesChecked {
     public List<AuthoritiesTypeChecked> findAuthoritiesChecked(List<Authorities> userAuthos,List<AuthoritiesType> types);


}
