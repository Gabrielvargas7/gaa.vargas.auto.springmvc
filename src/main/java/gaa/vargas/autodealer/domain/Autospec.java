/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class Autospec {

    private int autospecid;
    private int autoid;
    private String name;
    private String spec;

    public Autospec() {
    }


    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getAutospecid() {
        return autospecid;
    }

    public void setAutospecid(int autospecid) {
        this.autospecid = autospecid;
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



}
