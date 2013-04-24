/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

 import gaa.vargas.autodealer.domain.Spec;

import java.util.List;

/**
 *
 * @author gabriel
 */
public interface SpecDao {

    public List<Spec> findAll();
    public Spec findSpecBySpecId(int specid);
    public List<Spec> findAllByAutoid(int autoid);
    public void insert(Spec spec);
    public void delete(int specid);
    

}
