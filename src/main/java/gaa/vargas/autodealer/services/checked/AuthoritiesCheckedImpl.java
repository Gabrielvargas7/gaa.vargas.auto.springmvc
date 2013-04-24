/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.checked;

 import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.AuthoritiesType;
import gaa.vargas.autodealer.domain.AuthoritiesTypeChecked;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AuthoritiesCheckedImpl implements AuthoritiesChecked{

    public AuthoritiesCheckedImpl() {
    }


    public List<AuthoritiesTypeChecked> findAuthoritiesChecked(List<Authorities> userAuthos,List<AuthoritiesType> types)
    {
            List<AuthoritiesTypeChecked> typesChecked = new ArrayList<AuthoritiesTypeChecked>();


            for(AuthoritiesType type:types)
            {
                AuthoritiesTypeChecked authoFrontEnd = new AuthoritiesTypeChecked();
                authoFrontEnd.setAuthority(type.getAuthority());
                authoFrontEnd.setDescription(type.getDescription());
                authoFrontEnd.setChecked("");

                    for(Authorities userAutho: userAuthos)
                    {
                        if (authoFrontEnd.getAuthority().equals(userAutho.getAuthority()))
                        {
                            authoFrontEnd.setChecked("checked");
                            break;
                        }
                    }
                typesChecked.add(authoFrontEnd);
            }
          return typesChecked;

    }

}
