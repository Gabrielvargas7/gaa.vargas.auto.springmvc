/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class AuthoritiesType {

    private String authority;
    private String description;
  
    public AuthoritiesType() {
    }

    public AuthoritiesType(String authority, String description) {
        this.authority = authority;
        this.description = description;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }



}
