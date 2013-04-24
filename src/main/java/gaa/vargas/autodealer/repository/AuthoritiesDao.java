/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.AuthoritiesType;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface AuthoritiesDao {
    public List<Authorities> findAllAuthoritiesOfUsername(int userid);
    public List<AuthoritiesType> findAuthoritiesTypes();
    public String findAuthoritiesTypeDescription(String authority);
  


}
