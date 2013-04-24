/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.Spec;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

/**
 *
 * @author gabriel
 */
public class AutoDaoJdbc implements AutoDao
{

    private DataSource dataSource;
 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    public List<Auto> findAll()
    {
         List<Auto> autos = new ArrayList<Auto>();
         String sql = "SELECT * FROM autos ";
         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));
             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;
    }

    public List<Auto> findAll(int enabled)
    {
        String sql;
        sql = "SELECT * FROM autos WHERE enabled=?";
     
         List<Auto> autos = new ArrayList<Auto>();

         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(enabled));
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));
             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;

    }


    //**** NOTE
    //****    This metho call Adpect to validate the fieldname to
    //****    avoid injection.

    public List<Auto> findAllOrderBy(String fieldname) {

       // FieldDaoValidatorImpl validate = new FieldDaoValidatorImpl();
        List<Auto> autos = new ArrayList<Auto>();
        String sql;

        // if (validate.validateFieldName(fieldname))
       //  {
           sql = "SELECT * FROM autos ORDER BY "+fieldname;
       //  }else
       //  {
       //    sql = "SELECT * FROM autos";
       //  }

        //   String sql = "SELECT * FROM autos ";
         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));

             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("Enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;
    }


    //**** NOTE
    //****    This metho call Adpect to validate the fieldname to
    //****    avoid injection. autodealer.repository.AutoDaoValidateAspect

    public List<Auto> findAllOrderByWithEnabled(String fieldname,int enabled) {

       // FieldDaoValidatorImpl validate = new FieldDaoValidatorImpl();
        List<Auto> autos = new ArrayList<Auto>();
        String sql;

         sql = "SELECT * FROM autos WHERE enabled = ? ORDER BY "+fieldname;

         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,enabled);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));

             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("Enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;
    }


    public void insert(Auto auto, List<Spec> specs)
    {

        Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlAuto ="INSERT INTO autos "
                    +"(brand,model,year,price,createddate,begindate,enddate,enabled,userid,sold,miles)"
                    +"VALUES"
                    +"(?,?,?,?,CURRENT_DATE(),?,?,?,?,?,?)";
            PreparedStatement stAuto = conn.prepareStatement(sqlAuto,Statement.RETURN_GENERATED_KEYS);
            
            stAuto.setString(1, auto.getBrand());
            stAuto.setString(2, auto.getModel());
            stAuto.setInt(3, auto.getYear());
            stAuto.setDouble(4, auto.getPrice());
            stAuto.setDate(5, (Date)auto.getBegindate());
            stAuto.setDate(6, (Date)auto.getEnddate());
            stAuto.setInt(7, auto.getEnabled());
            stAuto.setInt(8, auto.getUserid());
            stAuto.setString(9, auto.getSold());
            stAuto.setInt(10, auto.getMiles());

        
            int rows = 0;
            rows = stAuto.executeUpdate();

            if(rows!=0)
            {
               ResultSet rs = stAuto.getGeneratedKeys();
                rs.next();
               auto.setAutoid(rs.getInt(1));
            }
            stAuto.close();

            for(Spec spec:specs)
            {
                String sqlSpec ="INSERT INTO autospec"
                        +"(autoid,name,spec)"
                        +"VALUES"
                        +"(?,?,?)";
                PreparedStatement stSpec = conn.prepareStatement(sqlSpec);
                stSpec.setInt(1,auto.getAutoid());
                stSpec.setString(2,spec.getName());
                stSpec.setString(3,spec.getSpec());
                stSpec.executeUpdate();
                stSpec.close();
            }
            conn.commit();
        }catch(SQLException e){if(conn != null){try {conn.rollback();}catch(SQLException e1){}}
        }finally{if (conn != null){try{conn.close();}catch(SQLException e){}}}

        
    }


    

    
    public void update(Auto auto, List<Spec> specs)
    {
    Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlAuto ="UPDATE autos SET "
                    +"brand   = ?, "
                    +"model  = ?, "
                    +"miles   = ?, "
                    +"year   = ?, "
                    +"price     = ?, "
                    +"begindate    = ?, "
                    +"enddate       = ?, "
                    +"enabled     = ?, "
                    +"sold     = ? "
                    +"WHERE autoid = ?";
            PreparedStatement stAuto = conn.prepareStatement(sqlAuto);
            stAuto.setString(1,auto.getBrand());
            stAuto.setString(2,auto.getModel());
            stAuto.setInt(3,auto.getMiles());
            stAuto.setInt(4,auto.getYear());
            stAuto.setDouble(5,auto.getPrice());
            stAuto.setDate(6, (Date) auto.getBegindate());
            stAuto.setDate(7, (Date) auto.getEnddate());
            stAuto.setInt(8,auto.getEnabled());
           
            stAuto.setString(9,auto.getSold());
            stAuto.setInt(10,auto.getAutoid());

            stAuto.executeUpdate();
            stAuto.close();

            String sqlDelete = "DELETE FROM autospec where autoid=?";
            PreparedStatement stmtDel = conn.prepareStatement(sqlDelete);
            stmtDel.setInt(1,auto.getAutoid());
            stmtDel.executeUpdate();
            stmtDel.close();

            for(Spec spec:specs)
            {
                String sqlSpec ="INSERT INTO autospec"
                        +"(autoid,name,spec)"
                        +"VALUES"
                        +"(?,?,?)";
                PreparedStatement stSpec = conn.prepareStatement(sqlSpec);
                stSpec.setInt(1,auto.getAutoid());
                stSpec.setString(2,spec.getName());
                stSpec.setString(3,spec.getSpec());
                stSpec.executeUpdate();
                stSpec.close();
            }
            conn.commit();
        }catch(SQLException e)
        {
            if(conn != null)
            {
                try {
                   conn.rollback();
                }catch(SQLException e1){}
            }
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }



    }

    public void disable(int autoid)
    {

      Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlAuto ="UPDATE autos SET "
                    +"enabled     = ? "
                    +"WHERE autoid = ?";
            PreparedStatement stAuto = conn.prepareStatement(sqlAuto);
            stAuto.setInt(1,0);
            stAuto.setInt(2,autoid);

            stAuto.executeUpdate();
            stAuto.close();
            conn.commit();
        }catch(SQLException e)
        {
            if(conn != null)
            {
                try {
                   conn.rollback();
                }catch(SQLException e1){}
            }
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }

    }

    public void enabled(int autoid)
    {
          Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlAuto ="UPDATE autos SET "
                    +"enabled     = ? "
                    +"WHERE autoid = ?";
            PreparedStatement stAuto = conn.prepareStatement(sqlAuto);
            stAuto.setInt(1,1);
            stAuto.setInt(2,autoid);

            stAuto.executeUpdate();
            stAuto.close();
            conn.commit();
        }catch(SQLException e)
        {
            if(conn != null)
            {
                try {
                   conn.rollback();
                }catch(SQLException e1){}
            }
        }finally
        {
            if (conn != null)
            {
                try{
                    conn.close();
                }catch(SQLException e){}
            }
        }
    }
    
    //**** NOTE
    //****    This metho is call by Adpect to validate the fieldname to
    //****    avoid injection. autodealer.repository.AutoDaoValidateAspect

    public List<Auto> findAllOrderByWithEnabledAscDesc(String fieldname,int enabled, String Ascending_Descending) {

        List<Auto> autos = new ArrayList<Auto>();
        String sql;

         sql = "SELECT * FROM autos WHERE enabled = ? ORDER BY "+fieldname+" "+Ascending_Descending;

         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,enabled);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));

             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("Enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;



    }
	
	public Set<String> findAllBrands() {
		// TODO Auto-generated method stub
	    //List<String> brands = new ArrayList<String>();
	    Set<String> brands = new TreeSet<String>();
	    
        String sql = "SELECT brand FROM autos GROUP BY brand ORDER  BY brand ASC";
        Connection conn = null;
        try{

           conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet row = ps.executeQuery();
           while (row.next())
           {
        	   brands.add(row.getString("brand"));
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
       return brands;
	}
	
	
	public List<Auto> findByFilter(int enabled, String filterValue) {

	    String sql;
        sql = "SELECT * FROM autos WHERE enabled=? AND brand=?";
     
         List<Auto> autos = new ArrayList<Auto>();

         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(enabled));
            ps.setString(2,filterValue);
            
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             Auto auto = new Auto();
             auto.setAutoid(row.getInt("autoid"));
             auto.setBrand(row.getString("brand"));
             auto.setModel(row.getString("model"));
             auto.setYear(row.getInt("year"));
             auto.setPrice(row.getDouble("price"));
             auto.setMiles(row.getInt("miles"));
             auto.setSold(row.getString("sold"));
             auto.setEnabled(row.getInt("enabled"));
             auto.setCreateddate((Date) row.getDate("createddate"));
             auto.setBegindate((Date) row.getDate("begindate"));
             auto.setEnddate((Date) row.getDate("enddate"));
             auto.setSold(row.getString("sold"));

             autos.add(auto);
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
        return autos;

	
	}
	
	
	//**** NOTE
    //****    This metho is call by Aspect to validate the fieldname to
    //****    avoid injection. autodealer.repository.AutoDaoValidateAspect
	public List<Auto> findByFilterOrderByWithEnabledAscDesc(String fieldname,
			int enabled, String ascendingDescending, String filterValue) {
	
		   List<Auto> autos = new ArrayList<Auto>();
	        String sql;

	         sql = "SELECT * FROM autos WHERE enabled = ? AND brand=? ORDER BY "+fieldname+" "+ascendingDescending;

	         Connection conn = null;
	         try{

	            conn = dataSource.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1,enabled);
	            ps.setString(2,filterValue);
	            ResultSet row = ps.executeQuery();
	            while (row.next())
	            {
	             Auto auto = new Auto();
	             auto.setAutoid(row.getInt("autoid"));
	             auto.setBrand(row.getString("brand"));
	             auto.setModel(row.getString("model"));
	             auto.setYear(row.getInt("year"));
	             auto.setPrice(row.getDouble("price"));
	             auto.setMiles(row.getInt("miles"));
	             auto.setSold(row.getString("sold"));

	             auto.setEnabled(row.getInt("enabled"));
	             auto.setCreateddate((Date) row.getDate("createddate"));
	             auto.setBegindate((Date) row.getDate("begindate"));
	             auto.setEnddate((Date) row.getDate("Enddate"));
	             auto.setSold(row.getString("sold"));

	             autos.add(auto);
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
	        return autos;

		
	}

	public Auto findByAutoid(int autoid) {
		
	        Auto auto = new Auto();
	        String sql;
	        sql = "SELECT * FROM autos WHERE autoid = ? ";
	         Connection conn = null;
	         try{
	            conn = dataSource.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1,autoid);
	            ResultSet row = ps.executeQuery();
	            while (row.next())
	            {
	             auto.setAutoid(row.getInt("autoid"));
	             auto.setBrand(row.getString("brand"));
	             auto.setModel(row.getString("model"));
	             auto.setYear(row.getInt("year"));
	             auto.setPrice(row.getDouble("price"));
	             auto.setMiles(row.getInt("miles"));
	             auto.setSold(row.getString("sold"));
	             auto.setEnabled(row.getInt("enabled"));
	             auto.setCreateddate((Date) row.getDate("createddate"));
	             auto.setBegindate((Date) row.getDate("begindate"));
	             auto.setEnddate((Date) row.getDate("Enddate"));
	             auto.setSold(row.getString("sold"));
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
	        return auto;
	    

	
	
	
	}



	public List<String> getGroupByFieldname(String groupfield) {
		// TODO Auto-generated method stub
		
	    String sql;
        sql = "SELECT "+groupfield+" FROM autos GROUP BY "+groupfield;
     
         List<String> values = new ArrayList<String>();

         Connection conn = null;
         try{

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
            	values.add(row.getString(groupfield));	
            }
            row.close();
            ps.close();
        }catch(SQLException e){throw new RuntimeException(e);
        }finally{if (conn != null){try{conn.close();}catch(SQLException e){}}}
        return values;
	}


	
	public List<String> getGroupByFieldnameWhereValue(String groupfield,
			String wherefield, String whereValue) {
		  String sql;
	        sql = "SELECT "+groupfield+" FROM autos WHERE "+wherefield+"=? GROUP BY "+groupfield;
	     
	         List<String> values = new ArrayList<String>();

	         Connection conn = null;
	         try{

	            conn = dataSource.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1,whereValue);
	            
	            ResultSet row = ps.executeQuery();
	            while (row.next())
	            {
	            	values.add(row.getString(groupfield));	
	            }
	            row.close();
	            ps.close();
	        }catch(SQLException e){throw new RuntimeException(e);
	        }finally{if (conn != null){try{conn.close();}catch(SQLException e){}}}
	        return values;

	}
    

}
