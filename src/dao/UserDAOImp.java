package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import domain.User;

public class UserDAOImp implements UserDAO {
    private String url = "jdbc:hsqldb:hsql://localhost";
    private String driver = "org.hsqldb.jdbcDriver";
    private String user = "sa";
    private String pass = "";

    @Override
    public boolean check(String username,String password) throws Exception {
        Class.forName(driver);
        String sql = "select * from user where username =? AND password=?";
        boolean isHave = false;
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery();) {
                isHave = rs.next();
            }
        }
        //密码检测
        return isHave;
    }
    /**
     * 得到所有学生 select * from user last,getRow当前时第几行,beforeFirst List<String[]>
     */
    // List<User>
    @Override
    public List<String[]> getAllUsers() throws Exception {   //通过数组得到用户信息
        List<String[]> users = new ArrayList<>();
        Class.forName(driver);
        String sql = "select * from user";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {// 保存每行的数据
                    String[] row = new String[5];
                    row[0] = rs.getString("id");
                    row[1] = rs.getString("username");
                    row[2] = rs.getString("sex");
                    row[3] = rs.getString("phone");
                    row[4] = rs.getString("birth");
                    users.add(row);
                }
            }
        }
        return users;
    }

    @Override
    public List<User> getAllUsersByObj() throws Exception {   //通过对象值传递展示所有用户信息
        List<User> users = new ArrayList<>();
        Class.forName(driver);
        String sql = "select * from user";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {// 保存每行的数据
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    users.add(user);
                }
            }
            return users;
        }
    }
    @Override
    public User findById(long id) throws Exception {       //通过ID号精确查找
        User users=new User();
        Class.forName(driver);
        String sql = "select * from user where id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(1,id);
            try (ResultSet rs = pstmt.executeQuery();) {
                rs.next();
                users.setId(rs.getLong("id"));
                users.setUsername(rs.getString("username"));
                users.setSex(rs.getString("sex"));
                users.setPhone(rs.getString("phone"));
                users.setBirth(rs.getDate("birth"));
            }
        }
        return users;
    }

    @Override
    public boolean save(User user1) throws Exception {
        boolean isSuc=false;
        Class.forName(driver);
        String sql = "insert into user(username,password,sex,phone,birth) values(?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1,user1.getUsername());
            pstmt.setString(2,user1.getPass());
            pstmt.setString(3,user1.getSex());
            pstmt.setString(4,user1.getPhone());
            pstmt.setDate(5,user1.getBirth());
            int row=pstmt.executeUpdate();
            isSuc=row>0;
        }
        return isSuc;
    }
    @Override
    public boolean update(User user1) throws Exception {
        boolean isSuc=false;
        Class.forName(driver);
        String sql = "update user set username=?,password=?,sex=?,phone=?,birth=? where id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1,user1.getUsername());
            pstmt.setString(2,user1.getPass());
            pstmt.setString(3,user1.getSex());
            pstmt.setString(4,user1.getPhone());
            pstmt.setDate(5,user1.getBirth());
            pstmt.setLong(6,user1.getId());
            int row=pstmt.executeUpdate();
            isSuc=row>0;
        }
        return isSuc;
    }

    @Override
    public boolean delById(long id) throws Exception {
        boolean isSuc = false;
        Class.forName(driver);
        String sql = "delete from user where id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            int row = pstmt.executeUpdate();
            isSuc = row > 0;
        }
        return isSuc;
    }
}
