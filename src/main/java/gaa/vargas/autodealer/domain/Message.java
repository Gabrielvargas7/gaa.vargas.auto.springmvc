/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class Message {
    private String name;
    private String description;

    public Message() {
    }

    public Message(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
