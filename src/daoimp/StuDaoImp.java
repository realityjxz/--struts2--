package daoimp;

import java.sql.*;
import java.util.*;

import dao.StuDao;
import domain.Stu;
import db.DBConn;

public class StuDaoImp implements StuDao {

    @Override
    public boolean check(String Sno, String Spass) {
        boolean isHave = false;
        String sql = "select * from tab_stu where Sno =? AND Spass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ps.setString(1, Sno);
            ps.setString(2, Spass);
            ResultSet rs = ps.executeQuery();
            isHave = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //账号密码检测
        return isHave;
    }


    @Override
    public List<Stu> getAllStusByObj() {   //通过对象值传递展示所有学生信息
        List<Stu> stus = new ArrayList<>();
        String sql = "select * from tab_stu";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Stu stu = new Stu();
                stu.setSno(rs.getString("Sno"));
                stu.setSpass(rs.getString("Spass"));
                stu.setSname(rs.getString("Sname"));
                stu.setSsex(rs.getString("Ssex"));
                stu.setSphone(rs.getString("Sphone"));
                stu.setSbirth(rs.getDate("Sbirth"));
                stu.setSclass(rs.getString("Sclass"));
                stus.add(stu);
               }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return stus;
    }

//    按学号查找
@Override
public Stu findBySno(String sno) {       //通过ID号精确查找
    Stu stu=new Stu();
    String sql = "select * from tab_stu where Sno=?";
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = DBConn.prepare(conn,sql);
    fingStu(sno, stu, conn, ps);
    return stu;
}

    @Override
    public Stu findBySclass(String sclass) {
        Stu stu=new Stu();
        String sql = "select * from tab_stu where Sclass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        fingStu(sclass, stu, conn, ps);
        return stu;
    }

    private void fingStu(String sclass, Stu stu, Connection conn, PreparedStatement ps) {       //提取方法——（学号、班级）查询
        try{
            ps.setString(1,sclass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            stu.setSno(rs.getString("Sno"));
            stu.setSpass(rs.getString("Spass"));
            stu.setSname(rs.getString("Sname"));
            stu.setSsex(rs.getString("Ssex"));
            stu.setSphone(rs.getString("Sphone"));
            stu.setSbirth(rs.getDate("Sbirth"));
            stu.setSclass(rs.getString("Sclass"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public boolean save(Stu stu) {
    boolean isSuc=false;
        String sql = "insert into tab_stu(Sno,Spass,Sname,Ssex,Sphone,Sbirth,Sclass)values(?,?,?,?,?,?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,stu.getSno());
            ps.setString(2,stu.getSpass());
            ps.setString(3,stu.getSname());
            ps.setString(4,stu.getSsex());
            ps.setString(5,stu.getSphone());
            ps.setDate(6,stu.getSbirth());
            ps.setString(7,stu.getSclass());
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
    public boolean update(Stu stu) {
        boolean isSuc=false;
        String sql = "update tab_stu set Spass=?,Sname=?,Ssex=?,Sphone=?,Sbirth=?,Sclass=? where Sno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,stu.getSpass());
            ps.setString(2,stu.getSname());
            ps.setString(3,stu.getSsex());
            ps.setString(4,stu.getSphone());
            ps.setDate(5,stu.getSbirth());
            ps.setString(6,stu.getSclass());
            ps.setString(7,stu.getSno());
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
    public boolean delBySno(String sno) {
        boolean isSuc=false;
        String sql = "delete from tab_stu where Sno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        isSuc = isSuc(sno, isSuc, conn, ps);
        return isSuc;
    }

    static boolean isSuc(String sno, boolean isSuc, Connection conn, PreparedStatement ps) {
        try{
            ps.setString(1,sno);
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


}
