/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class SpecChecked extends Spec
{
    private  String checked;

    public SpecChecked(int specid, String name, String spec, String checked)
    {
        super(specid,name,spec);
        this.checked = checked;
    }

    public SpecChecked() {
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getChecked() {
        return checked;
    }


    




}
