/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.filter;

import gaa.vargas.autodealer.domain.User;


/**
 *
 * @author gabriel
 */
public  class UserFilterImpl implements UserFilter {

    public UserFilterImpl() {
    }

    public void toLowerCaseUserString(User user) {
        user.setFirstname(user.getFirstname().toLowerCase());
        user.setLastname(user.getLastname().toLowerCase());
        user.setUsername(user.getUsername().toLowerCase());
        user.setAddress(user.getAddress().toLowerCase());
        user.setCity(user.getCity().toLowerCase());
        user.setState(user.getState().toLowerCase());
        user.setZip(user.getZip().toLowerCase());
    }


}
