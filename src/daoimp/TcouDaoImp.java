package daoimp;

import dao.TcouDao;
import db.DBConn;
import domain.Tcou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class TcouDaoImp implements TcouDao {

    @Override
    public List<Tcou> getAllTcousByObj() {                                   //管理员查看所有授课表

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

    //教师授课表查询
    @Override
    public List<Tcou> getAllCname(String tno) {                            //通过教师号查所教课程名-教师首页
        List<Tcou> couscores = new ArrayList<>();
        String sql = "select DISTINCT Cno,Cname,Cterm from TAB_COU,TAB_TCOU where TAB_TCOU.CNO=TAB_COU.CNO and TNO="+tno;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tcou couscore=new Tcou();
                couscore.setCno(rs.getString("Cno"));
                couscore.setCname(rs.getString("Cname"));
                couscore.setCterm(rs.getString("Cterm"));
                couscores.add(couscore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return couscores;
    }




    @Override
    public Tcou findByCno(String cno,String tno,String sclass) {
        Tcou tcou = new Tcou();
        String sql = "select * from (select tab_tcou.Cno,tab_tcou.Tno,tab_tcou.Sclass,Site,Cname,Tname FROM tab_tcou,tab_cou,tab_tea WHERE tab_tcou.Cno=tab_cou.Cno AND tab_tcou.Tno=tab_tea.Tno) as t  where t.Cno="+cno+"and t.Tno="+tno+"and t.Sclass="+sclass;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn, sql);
        try {
            ResultSet rs = ps.executeQuery();
            rs.next();
            tcou.setCno(rs.getString("Cno"));
            tcou.setCname(rs.getString("Cname"));
            tcou.setTno(rs.getString("Tno"));
            tcou.setTname(rs.getString("Tname"));
            tcou.setSclass(rs.getString("Sclass"));
            tcou.setSite(rs.getString("Site"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return tcou;
    }

    @Override
    public List<Tcou> findByTno(String tno){                                      //老师查
        List<Tcou> tcous = new ArrayList<>();
        String sql = "select TAB_TCOU.Cno,Cname,Cterm,Credit,Site,Sclass from TAB_COU,TAB_TCOU where TAB_TCOU.CNO=TAB_COU.CNO and TNO="+tno;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tcou tcou=new Tcou();
                tcou.setCno(rs.getString("Cno"));
                tcou.setCname(rs.getString("Cname"));
                tcou.setCterm(rs.getString("Cterm"));
                tcou.setSclass(rs.getString("Sclass"));
                tcou.setCredit(rs.getString("Credit"));
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
    public List<Tcou> findBySno(String sno) {                             //学生查
        List<Tcou> tcous = new ArrayList<>();
        String sql = "select TAB_TCOU.Cno,Cname,Cterm TAB_TCOU.Sclass,Credit,Site,TAB_TCOU.Tno,TAB_TEA.Tname from TAB_COU,TAB_TCOU,TAB_TEA where TAB_TCOU.CNO=TAB_COU.CNO and TAB_TCOU.Tno=TAB_TEA.Tno and TAB_TCOU.SCLASS=(select Sclass from TAB_STU where Sno=?)";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try{
            ps.setString(1,sno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tcou tcou=new Tcou();
                tcou.setCno(rs.getString("Cno"));
                tcou.setCname(rs.getString("Cname"));
                tcou.setTno(rs.getString("Tno"));
                tcou.setTname(rs.getString("Tname"));
                tcou.setCterm(rs.getString("Cterm"));
                tcou.setCredit(rs.getString("Credit"));
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
