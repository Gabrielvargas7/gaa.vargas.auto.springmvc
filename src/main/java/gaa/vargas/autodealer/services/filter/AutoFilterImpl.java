/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.filter;

import gaa.vargas.autodealer.domain.Auto;


/**
 *
 * @author gabriel
 */
public  class AutoFilterImpl implements AutoFilter {

    public AutoFilterImpl() {
    }

    public void toLowerCaseAutoString(Auto auto)
    {
        auto.setBrand(auto.getBrand().toLowerCase());
        auto.setModel(auto.getModel().toLowerCase());

        
    }


}
