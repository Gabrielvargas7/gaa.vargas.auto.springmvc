/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.AuthoritiesType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author gabriel
 */
public class AuthoritiesDaoJdbc implements AuthoritiesDao{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

 
    public List<Authorities> findAllAuthoritiesOfUsername(int userid)
    {

        String sql = "SELECT authority FROM authorities WHERE userid=?";
        Connection conn = null;
        List<Authorities> authorities = new ArrayList<Authorities>();

        try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,userid);
             ResultSet row = ps.executeQuery();

             while(row.next())
             {
                 Authorities authority = new Authorities();
                 authority.setAuthority( row.getString("authority"));
                 authorities.add(authority);
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

        return authorities;


        
    }

    public List<AuthoritiesType> findAuthoritiesTypes()
    {
        String sql = "SELECT authority,description FROM authoritiestypes GROUP BY authority";
        Connection conn = null;
        List<AuthoritiesType> authorities = new ArrayList<AuthoritiesType>();

        try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet row = ps.executeQuery();

             while(row.next())
             {
                 AuthoritiesType authorityType = new AuthoritiesType();
                 authorityType.setAuthority( row.getString("authority"));
                 authorityType.setDescription(row.getString("description"));
                 authorities.add(authorityType);
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

        return authorities;


    }

    public String findAuthoritiesTypeDescription(String authority)
    {
        String description = null;
        String sql = "SELECT description FROM authoritiestypes where authority=?";
        Connection conn = null;
        try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,authority);
             ResultSet row = ps.executeQuery();

             if(row.next())
             {
                 description = row.getString("description");

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

        return description;




    }


}
