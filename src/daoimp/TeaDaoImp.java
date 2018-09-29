package daoimp;

import dao.TeaDao;
import domain.Tea;
import db.DBConn;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TeaDaoImp implements TeaDao {
    @Override
    public boolean check(String Tno, String Tpass) {
        boolean isHave = false;
        Connection conn = DBConn.getConnection();
        String sql = "select * from tab_tea where Tno =? AND Tpass=?";
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1, Tno);
            ps.setString(2, Tpass);
            try (ResultSet rs = ps.executeQuery()) {
                isHave = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(conn);
            DBConn.close(ps);
            }
        return isHave;
    }

    @Override
    public List<Tea> getAllTeasByObj() {                 //通过对象值传递展示所有教师信息
            List<Tea> teas = new ArrayList<>();
            String sql = "select * from tab_tea";
            Connection conn = DBConn.getConnection();
            PreparedStatement ps = DBConn.prepare(conn, sql);
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {// 保存每行的数据
                    Tea tea = new Tea();
                    tea.setTno(rs.getString("Tno"));
                    tea.setTpass(rs.getString("Tpass"));
                    tea.setTname(rs.getString("Tname"));
                    tea.setTsex(rs.getString("Tsex"));
                    tea.setTphone(rs.getString("Tphone"));
                    tea.setTbirth(rs.getDate("Tbirth"));
                    teas.add(tea);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConn.close(ps);
                DBConn.close(conn);
            }
            return teas;
        }
    @Override
    public Tea findByTno(String tno) {               //老师自己查询信息
        Tea tea=new Tea();
        String sql = "select * from tab_tea where Tno="+tno;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        System.out.println(ps.toString());

        try{
            ResultSet rs = ps.executeQuery();
            rs.next();
            tea.setTno(rs.getString("Tno"));
            tea.setTpass(rs.getString("Tpass"));
            tea.setTname(rs.getString("Tname"));
            tea.setTsex(rs.getString("Tsex"));
            tea.setTphone(rs.getString("Tphone"));
            tea.setTbirth(rs.getDate("Tbirth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return tea;
    }

    @Override
    public boolean updatepass(String Tno,String pass) {               //老师自己修改密码
        boolean isSuc=false;
        String sql = "update tab_tea set Tpass=? where Tno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,pass);
            System.out.println(pass);
            ps.setString(2,Tno);
            System.out.println(Tno);
            int row = ps.executeUpdate();
            isSuc = row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return isSuc;
    }

    @Override
    public boolean save(Tea tea) {
        boolean isSuc=false;
        String sql = "insert into tab_tea(Tno,Tpass,Tname,Tsex,Tphone,Tbirth)values(?,?,?,?,?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,tea.getTno());
            ps.setString(2,tea.getTpass());
            ps.setString(3,tea.getTname());
            ps.setString(4,tea.getTsex());
            ps.setString(5,tea.getTphone());
            ps.setDate(6,tea.getTbirth());
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

    public boolean update(Tea tea) {
        boolean isSuc=false;
        String sql = "update tab_tea set Tpass=?,Tname=?,Tsex=?,Tphone=?,Tbirth=?, where Tno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,tea.getTpass());
            ps.setString(2,tea.getTname());
            ps.setString(3,tea.getTsex());
            ps.setString(4,tea.getTphone());
            ps.setDate(5,tea.getTbirth());
            ps.setString(6,tea.getTno());
            int row = ps.executeUpdate();
            isSuc = row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }

        return isSuc;
    }

    @Override
    public boolean delByTno(String tno) {
        boolean isSuc=false;
        String sql = "delete from tab_tea where Tno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        isSuc = StuDaoImp.isSuc(tno, isSuc, conn, ps);
        return isSuc;
    }
}
