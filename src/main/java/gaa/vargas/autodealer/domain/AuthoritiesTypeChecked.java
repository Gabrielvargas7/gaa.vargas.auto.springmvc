/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class AuthoritiesTypeChecked extends AuthoritiesType
{
    private  String checked;

    public AuthoritiesTypeChecked(String authority, String description, String checked) {
        super(authority, description);
        this.checked = checked;
    }

    public AuthoritiesTypeChecked() {
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getChecked() {
        return checked;
    }


    




}
