/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;


 import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface UserDao {
    public void insert(User user,List<Authorities> authorities);
    public void update(User user,List<Authorities> authorities);   
    public User findByUserId(int userid);
    public List<User> findAll();
    public List<User> findAllOrderBy(String fieldname);
 
    public void enabled(int userid);
    public void disable(int userid);
    public void changePassword(User user);


}
