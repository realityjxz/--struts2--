package daoimp;

import dao.CouDao;
import db.DBConn;
import domain.Cou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouDaoImp implements CouDao {
    @Override
    public List<Cou> getAllCousByObj() {
        List<Cou> cous = new ArrayList<>();
        String sql = "select * from tab_cou";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cou cou = new Cou();
                cou.setCno(rs.getString("Cno"));
                cou.setCname(rs.getString("Cname"));
                cou.setCterm(rs.getString("Cterm"));
                cou.setCredit(rs.getInt("Credit"));
                cous.add(cou);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return cous;
    }

    @Override
    public Cou findByCno(String cno) {
        Cou cou = new Cou();
        String sql = "select from tab_cou where Cno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cou.setCno(rs.getString("Cno"));
            cou.setCname(rs.getString("Cname"));
            cou.setCterm(rs.getString("Cterm"));
            cou.setCredit(rs.getInt("Credit"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return cou;
    }

    @Override
    public boolean save(Cou cou) {
        boolean isSuc = false;
        String sql = "insert into tab_cou(Cno,Cname,Cterm,Credit)values(?,?,?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ps.setString(1, cou.getCno());
            ps.setString(2, cou.getCname());
            ps.setString(3, cou.getCterm());
            ps.setInt(4, cou.getCredit());
            int row = ps.executeUpdate();
        isSuc = row > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBConn.close(ps);
        DBConn.close(conn);
    }
        return isSuc;
    }

    @Override
    public boolean delByCno(String cno) {
        boolean isSuc = false;
        String sql = "delete from tab_cou where Cno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        isSuc = StuDaoImp.isSuc(cno, isSuc, conn, ps);

        return isSuc;
    }

    @Override
    public boolean update(Cou cou) {
        boolean isSuc = false;
        String sql = "update tab_cou set Cname=?,Cterm=?,Credit=? where Cno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ps.setString(1, cou.getCname());
            ps.setString(2, cou.getCterm());
            ps.setInt(3, cou.getCredit());
            ps.setString(4, cou.getCno());
            int row = ps.executeUpdate();
            isSuc = row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return isSuc;
    }
}
