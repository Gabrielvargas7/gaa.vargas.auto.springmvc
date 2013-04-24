/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

 import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.Spec;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author gabriel
 */
public interface AutoDao
{
    public void insert(Auto auto,List<Spec> specs);
    public List<Auto> findAll();
    public List<Auto> findAll(int enabled);
    public List<Auto> findAllOrderBy(String fieldname);
    public List<Auto> findAllOrderByWithEnabled(String fieldname,int enabled);
    public List<Auto> findAllOrderByWithEnabledAscDesc(String fieldname,int enabled,String ascending_descending);
    

    public Auto findByAutoid(int autoid);
    public void update(Auto auto, List<Spec> specs);

    public void disable(int autoid);
    public void enabled(int autoid);
	public Set<String> findAllBrands();
		
	public List<Auto> findByFilter(int enabled, String filterValue);
	
	public List<Auto> findByFilterOrderByWithEnabledAscDesc(String fieldname,
			int enabled, String ascendingDescending, String filterValue);

	public List<String> getGroupByFieldname(String groupfield);
	
	public List<String> getGroupByFieldnameWhereValue
	(String groupfield,String wherefield,String whereValue);
	


}
