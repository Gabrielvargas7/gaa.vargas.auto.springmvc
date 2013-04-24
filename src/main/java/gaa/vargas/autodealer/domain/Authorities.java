/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.domain;

/**
 *
 * @author gabriel
 */
public class Authorities {
   private Integer authorityid;
   private Integer userid;
   private String  username;
   private String  authority;
   private String  description;

    public Authorities() {
    }


    public Authorities(Integer authorityid, Integer userid, String username, String authority, String description) {
        this.authorityid = authorityid;
        this.userid = userid;
        this.username = username;
        this.authority = authority;
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
