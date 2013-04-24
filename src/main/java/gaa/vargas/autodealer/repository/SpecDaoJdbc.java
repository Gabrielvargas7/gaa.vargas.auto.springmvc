/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Spec;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author gabriel
 */
public class SpecDaoJdbc implements SpecDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    

    public List<Spec> findAll()
    {

         List<Spec> specs = new ArrayList<Spec>();
         String sql = "SELECT * FROM spec ORDER BY name";
         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Spec spec = new Spec();
             spec. setSpecid(row.getInt("specid"));
             spec.setName(row.getString("name"));
             spec.setSpec(row.getString("spec"));
             specs.add(spec);
            }
            row.close();
            ps.close();

        }catch(SQLException e)
        {
           throw new RuntimeException(e);
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }
        return specs;

    }


    public Spec findSpecBySpecId(int specid)
    {
         Spec spec = new Spec();

         String sql = "SELECT * FROM spec WHERE specid=?";
         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, specid);
            ResultSet row = ps.executeQuery();


            while (row.next())
            {
             spec. setSpecid(row.getInt("specid"));
             spec.setName(row.getString("name"));
             spec.setSpec(row.getString("spec"));
            }
            row.close();
            ps.close();

        }catch(SQLException e)
        {
           throw new RuntimeException(e);
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }
        return spec;


    }


    public List<Spec> findAllByAutoid(int autoid) {

      List<Spec> specs = new ArrayList<Spec>();
         String sql = "SELECT * FROM autospec WHERE autoid=? ";
         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, autoid);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Spec spec = new Spec();
             
             spec.setName(row.getString("name"));
             spec.setSpec(row.getString("spec"));
             specs.add(spec);
            }
            row.close();
            ps.close();

        }catch(SQLException e)
        {
           throw new RuntimeException(e);
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }
        return specs;
    }

	public void insert(Spec spec) {
		
		   Connection conn = null;
	        try{
	             conn = dataSource.getConnection();
	             conn.setAutoCommit(false);

	                String sqlSpec ="INSERT INTO spec"
	                        +"(name,spec)"
	                        +"VALUES"
	                        +"(?,?)";
	                PreparedStatement stSpec = conn.prepareStatement(sqlSpec);
	                stSpec.setString(1,spec.getName());
	                stSpec.setString(2,spec.getSpec());
	                stSpec.executeUpdate();
	                stSpec.close();
	            conn.commit();
	        }catch(SQLException e){if(conn != null){try {conn.rollback();}catch(SQLException e1){}}
	        }finally{if (conn != null){try{conn.close();}catch(SQLException e){}}}


		
	}


	public void delete(int specid) {
		 Connection conn = null;
	        try{
	             conn = dataSource.getConnection();
	             conn.setAutoCommit(false);

	                String sqlSpec ="DELETE FROM spec WHERE specid=?"; 
	                       
	                PreparedStatement stSpec = conn.prepareStatement(sqlSpec);
	                stSpec.setInt(1,specid);
	                stSpec.executeUpdate();
	                stSpec.close();
	            conn.commit();
	        }catch(SQLException e){if(conn != null){try {conn.rollback();}catch(SQLException e1){}}
	        }finally{if (conn != null){try{conn.close();}catch(SQLException e){}}}
		
		
		// TODO Auto-generated method stub
		
	}


}
