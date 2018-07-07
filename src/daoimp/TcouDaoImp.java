package daoimp;

import dao.TcouDao;
import db.DBConn;
import domain.Tcou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class TcouDaoImp implements TcouDao {

    @Override
    public List<Tcou> getAllTcousByObj() {

        List<Tcou> tcous = new ArrayList<>();
        String sql = "select tab_tcou.Cno,tab_tcou.Tno,tab_tcou.Sclass,Site,Cname,Tname FROM tab_tcou,tab_cou,tab_tea WHERE tab_tcou.Cno=tab_cou.Cno AND tab_tcou.Tno=tab_tea.Tno";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tcou tcou = new Tcou();
                tcou.setCno(rs.getString("tab_tcou.Cno"));
                tcou.setCname(rs.getString("Cname"));
                tcou.setTno(rs.getString("tab_tcou.Tno"));
                tcou.setTname(rs.getString("Tname"));
                tcou.setSclass(rs.getString("Sclass"));
                tcou.setSite(rs.getString("Site"));
                tcous.add(tcou);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return tcous;
    }

    @Override
    public Tcou findByCno(String cno) {
        Tcou tcou = new Tcou();
        String sql = "select from tab_tcou where Cno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        findTcou(cno, tcou, conn, ps);
        return tcou;
    }

    @Override
    public Tcou findByTno(String tno) {
        Tcou tcou = new Tcou();
        String sql = "select from tab_tcou where Tno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        findTcou(tno, tcou, conn, ps);
        return tcou;
    }

    private void findTcou(String tno, Tcou tcou, Connection conn, PreparedStatement ps) {     //提取的方法——（课程号、工号、班级）查询
        try {
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tcou.setCno(rs.getString("Cno"));
            tcou.setTno(rs.getString("Tno"));
            tcou.setSclass(rs.getString("Sclass"));
            tcou.setSite(rs.getString("Site"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
    }

    @Override
    public Tcou findBySclass(String sclass) {
        Tcou tcou = new Tcou();
        String sql = "select from tab_tcou where Sclass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        findTcou(sclass, tcou, conn, ps);
        return tcou;
    }

    @Override
    public boolean save(Tcou tcou) {
        boolean isSuc = false;
        String sql = "insert into tab_tcou(Cno,Tno,Sclass,Site)values(?,?,?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ps.setString(1, tcou.getCno());
            ps.setString(2, tcou.getTno());
            ps.setString(3, tcou.getSclass());
            ps.setString(4, tcou.getSite());
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
    public boolean update(Tcou tcou) {
        boolean isSuc = false;
        String sql = "update tab_tcou set Tno=?,Sclass=?,Site=? where Cno=? ";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {

            ps.setString(1, tcou.getTno());
            ps.setString(2, tcou.getSclass());
            ps.setString(3, tcou.getSite());
            ps.setString(4, tcou.getCno());
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
