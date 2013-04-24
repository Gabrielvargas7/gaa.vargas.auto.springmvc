/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class Spec {
    private int specid;
    private String name;
    private String spec;

    public Spec() {
    }

    public Spec(int specid, String name, String spec) {
        this.specid = specid;
        this.name = name;
        this.spec = spec;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getSpecid() {
        return specid;
    }

    public void setSpecid(int specid) {
        this.specid = specid;
    }


}
