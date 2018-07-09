package daoimp;

import dao.ClaDao;
import db.DBConn;
import domain.Cla;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClaDaoImp implements ClaDao {
    @Override
    public List<Cla> getAllClasByObj() {
        List<Cla> clas = new ArrayList<>();
        String sql = "select * from tab_cla";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cla cla = new Cla();
                cla.setSclass(rs.getString("Sclass"));
                cla.setSclasstea(rs.getString("Sclasstea"));
                clas.add(cla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return clas;
    }

    @Override
    public Cla findBySclass(String sclass) {
        Cla cla=new Cla();
        String sql = "select * from tab_cla where Sclass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ps.setString(1, sclass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cla.setSclass(rs.getString("Sclass"));
            cla.setSclasstea(rs.getString("Sclasstea"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }

        return cla;
    }

    @Override
    public boolean save(Cla cla) {
        boolean isSuc = false;
        String sql = "insert into tab_cla(Sclass,Sclasstea)values(?,?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try{
            ps.setString(1,cla.getSclass());
            ps.setString(2,cla.getSclasstea());
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
    public boolean delBySclass(String sclass) {
        boolean isSuc = false;
        String sql = "delete from tab_cla where Sclass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        isSuc = StuDaoImp.isSuc(sclass, isSuc, conn, ps);
        return isSuc;
    }

    @Override
    public boolean update(Cla cla) {
        boolean isSuc = false;
        String sql = "update tab_cla set Sclasstea=? where Sclass=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try{
            ps.setString(1,cla.getSclasstea());
            ps.setString(2,cla.getSclass());
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }

        return isSuc;
    }
}
