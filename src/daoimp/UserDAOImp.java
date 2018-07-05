package daoimp;

import java.sql.*;
import java.util.*;

import dao.UserDAO;
import domain.User;
import db.DBConn;

public class UserDAOImp implements UserDAO {

    //用户名密码检测
    @Override
    public boolean check(String username,String password){
        boolean isHave = false;
        Connection conn = DBConn.getConnection();
        String sql = "select * from user where username =? AND password=?";
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
                isHave = rs.next();
            }catch(SQLException e){
                e.printStackTrace();
                }finally {
                DBConn.close(ps);
                DBConn.close(conn);
            }
        return isHave;
    }
    /**
     * 得到所有用户 select * from user last,getRow当前时第几行,beforeFirst List<String[]>
     */
    // List<User>
    @Override
    public List<String[]> getAllUsers() {   //通过数组得到用户信息
        List<String[]> users = new ArrayList<>();
        String sql = "select * from user";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
            try{
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {// 保存每行的数据
                    String[] row = new String[5];
                    row[0] = rs.getString("id");
                    row[1] = rs.getString("username");
                    row[2] = rs.getString("sex");
                    row[3] = rs.getString("phone");
                    row[4] = rs.getString("birth");
                    users.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
//                DBConn.close(rs);
                DBConn.close(ps);
                DBConn.close(conn);
            }
        return users;
    }

    @Override
    public List<User> getAllUsersByObj() {   //通过对象值传递展示所有用户信息
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {// 保存每行的数据
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPass(rs.getString("password"));
                    user.setSex(rs.getString("sex"));
                    user.setPhone(rs.getString("phone"));
                    user.setBirth(rs.getDate("birth"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                DBConn.close(ps);
                DBConn.close(conn);
            }
        return users;

    }
    @Override
    public User findById(long id) {       //通过ID号精确查找
        User users=new User();
        String sql = "select * from user where id=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
                rs.next();
                users.setId(rs.getLong("id"));
                users.setUsername(rs.getString("username"));
                users.setSex(rs.getString("sex"));
                users.setPhone(rs.getString("phone"));
                users.setBirth(rs.getDate("birth"));
            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return users;
    }

    @Override
    public boolean save(User user)  {
        boolean isSuc=false;
        String sql = "insert into user(username,password,sex,phone,birth) values(?,?,?,?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPass());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getPhone());
            ps.setDate(5,user.getBirth());
            int row=ps.executeUpdate();
            isSuc=row>0;
        } catch (SQLException e) {
                e.printStackTrace();
            }
        finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return isSuc;
    }
    @Override
    public boolean update(User user) {
        boolean isSuc=false;
        String sql = "update user set username=?,password=?,sex=?,phone=?,birth=? where id=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPass());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getPhone());
            ps.setDate(5,user.getBirth());
            ps.setLong(6,user.getId());
            int row=ps.executeUpdate();
            isSuc=row>0;
        } catch (SQLException e) {
                e.printStackTrace();
            }
        finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return isSuc;
    }

    @Override
    public boolean delById(long id) {
        boolean isSuc = false;
        String sql = "delete from user where id=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
            try {
                ps.setLong(1, id);
                int row = ps.executeUpdate();
                isSuc = row > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                DBConn.close(ps);
                DBConn.close(conn);
            }
        return isSuc;
    }
}
