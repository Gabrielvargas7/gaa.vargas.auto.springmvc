/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.repository;

import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author gabriel
 */
public class UserDaoJdbc  implements  UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void insert(User user,List<Authorities> authorities)
    {
        Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlUser ="INSERT INTO users "
                    +"(username,firstname,lastname,password,active,enabled,created_date,address,city,state,zip,phone1,phone2)"
                    +"VALUES"
                    +"(?,?,?,?,?,?,CURRENT_DATE(),?,?,?,?,?,?)";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);

            stmtUser.setString(1,user.getUsername());
            stmtUser.setString(2,user.getFirstname());
            stmtUser.setString(3,user.getLastname());
            stmtUser.setString(4,user.getPassword()); //'81dc9bdb52d04dc20036dbd8313ed055'
            stmtUser.setString(5,user.getActive());
            stmtUser.setInt(6,user.getEnabled());
            stmtUser.setString(7,user.getAddress());
            stmtUser.setString(8,user.getCity());
            stmtUser.setString(9,user.getState());
            stmtUser.setString(10,user.getZip());
            stmtUser.setString(11,user.getPhone1());
            stmtUser.setString(12,user.getPhone2());
            stmtUser.executeUpdate();
            stmtUser.close();

            String sqlGetUserId = "SELECT userid FROM users where username=?";
            PreparedStatement stmtGetUserId = conn.prepareStatement(sqlGetUserId);
            stmtGetUserId.setString(1,user.getUsername());
            ResultSet rs = stmtGetUserId.executeQuery();
            if (rs.next())
            {
                user.setUserid(rs.getInt("userid"));
            }else
            {
                conn.rollback();
            }
            stmtGetUserId.close();
            rs.close();
            for(Authorities authority:authorities)
            {
                String sqlAutho ="INSERT INTO authorities"
                        +"(userid,username,authority)"
                        +"VALUES"
                        +"(?,?,?)";
                PreparedStatement stmtAutho = conn.prepareStatement(sqlAutho);
                stmtAutho.setInt(1,user.getUserid());
                stmtAutho.setString(2,user.getUsername());
                stmtAutho.setString(3,authority.getAuthority());
                stmtAutho.executeUpdate();
                stmtAutho.close();
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

    public void update(User user, List<Authorities> authorities)
    {
        Connection conn = null;
        try{
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             String sqlUser ="UPDATE users SET "
                    +"username   = ?, "
                    +"firstname  = ?, "
                    +"lastname   = ?, "
                    +"password   = ?, "
                    +"active     = ?, "
                    +"enabled    = ?, "
                    +"address    = ?, "
                    +"city       = ?, "
                    +"state      = ?, "
                    +"zip        = ?, "
                    +"phone1     = ?, "
                    +"phone2     = ?, "
                    +"created_date = ? "
                    +"WHERE userid = ?";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
            stmtUser.setString(1,user.getUsername());
            stmtUser.setString(2,user.getFirstname());
            stmtUser.setString(3,user.getLastname());
            stmtUser.setString(4,user.getPassword()); //'81dc9bdb52d04dc20036dbd8313ed055'
            stmtUser.setString(5,user.getActive());
            stmtUser.setInt(6,user.getEnabled());
            stmtUser.setString(7,user.getAddress());
            stmtUser.setString(8,user.getCity());
            stmtUser.setString(9,user.getState());
            stmtUser.setString(10,user.getZip());
            stmtUser.setString(11,user.getPhone1());
            stmtUser.setString(12,user.getPhone2());
            stmtUser.setDate(13, (Date) user.getCreated_date());
            stmtUser.setInt(14,user.getUserid());
            stmtUser.executeUpdate();
            stmtUser.close();
            String sqlDelete = "DELETE FROM authorities where userid=?";
            PreparedStatement stmtDel = conn.prepareStatement(sqlDelete);
            stmtDel.setInt(1,user.getUserid());
            stmtDel.executeUpdate();
            stmtDel.close();
            for(Authorities authority:authorities)
            {
                String sqlAutho ="INSERT INTO authorities"
                        +"(userid,username,authority)"
                        +"VALUES"
                        +"(?,?,?)";
                PreparedStatement stmtAutho = conn.prepareStatement(sqlAutho);
                stmtAutho.setInt(1,user.getUserid());
                stmtAutho.setString(2,user.getUsername());
                stmtAutho.setString(3,authority.getAuthority());
                stmtAutho.executeUpdate();
                stmtAutho.close();
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
 
    public User findByUserId(int userid)
    {
         User user = new User();
         String sql = "SELECT * FROM users WHERE userid=? ";
         Connection conn = null;
         try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,userid);
             ResultSet row = ps.executeQuery();
            while (row.next())
            {
                 user.setUserid(row.getInt("userid"));
                 user.setFirstname(row.getString("firstname"));
                 user.setLastname(row.getString("lastname"));
                 user.setUsername(row.getString("username"));
                 user.setPassword(row.getString("password"));
                 user.setActive(row.getString("active"));
                 user.setEnabled(row.getInt("enabled"));
                 user.setCreated_date((Date) row.getDate("created_date"));
                 user.setAddress(row.getString("address"));
                 user.setCity(row.getString("city"));
                 user.setState(row.getString("state"));
                 user.setZip(row.getString("zip"));
                 user.setPhone1(row.getString("phone1"));
                 user.setPhone2(row.getString("phone2"));
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
        return user;
    }

    public List<User> findAll()
    {
         List<User> users = new ArrayList<User>();
         String sql = "SELECT * FROM users ";
         Connection conn = null;
         try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             User user = new User();
             user.setUserid(row.getInt("userid"));
             user.setFirstname(row.getString("firstname"));
             user.setLastname(row.getString("lastname"));
             user.setUsername(row.getString("username"));
             user.setActive(row.getString("active"));
             user.setEnabled(row.getInt("enabled"));
             user.setCreated_date((Date) row.getDate("created_date"));
             user.setAddress(row.getString("address"));
             user.setCity(row.getString("city"));
             user.setState(row.getString("state"));
             user.setZip(row.getString("zip"));
             user.setPhone1(row.getString("phone1"));
             user.setPhone2(row.getString("phone2"));
             users.add(user);
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
        return users;
    }

    public void enabled(int userid) {
         String sql = "UPDATE users SET enabled = 1 WHERE userid = ? ";
         Connection conn = null;
         try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,userid);
             ps.executeUpdate();
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
    }

    public void disable(int userid)
    {
         String sql = "UPDATE users SET enabled = 0 WHERE userid = ? ";
         Connection conn = null;
         try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,userid);
             ps.executeUpdate();
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
    }
    public void changePassword(User user)
    {
         String sql = "UPDATE users SET password = ? WHERE userid=? ";
         Connection conn = null;
         try{
             conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,user.getPassword());
             ps.setInt(2,user.getUserid());
             ps.executeUpdate();
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
    }

    //**** NOTE
    //****    This metho call Adpect to validate the fieldname to
    //****    avoid injection.
    public List<User> findAllOrderBy(String fieldname)
    {
         List<User> users = new ArrayList<User>();
         String sql;
           sql = "SELECT * FROM users ORDER BY "+fieldname;
         Connection conn = null;
         try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet row = ps.executeQuery();
            while (row.next())
            {
             User user = new User();
             user.setUserid(row.getInt("userid"));
             user.setFirstname(row.getString("firstname"));
             user.setLastname(row.getString("lastname"));
             user.setUsername(row.getString("username"));
             user.setActive(row.getString("active"));
             user.setEnabled(row.getInt("enabled"));
             user.setCreated_date((Date) row.getDate("created_date"));
             user.setAddress(row.getString("address"));
             user.setCity(row.getString("city"));
             user.setState(row.getString("state"));
             user.setZip(row.getString("zip"));
             user.setPhone1(row.getString("phone1"));
             user.setPhone2(row.getString("phone2"));
             users.add(user);
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
        return users;
    }


}
