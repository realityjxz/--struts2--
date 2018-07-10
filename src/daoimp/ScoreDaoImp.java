package daoimp;

import dao.ScoreDao;
import domain.Score;
import db.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImp implements ScoreDao {
    @Override
    public List<Score> getAllScoresByObj() {                //查成绩表
        List<Score> scores = new ArrayList<>();
        String sql = "select tab_score.Cno,tab_score.Sno,Cname,Sname,Sclass,Score FROM tab_score,tab_stu,tab_cou WHERE tab_score.Cno=tab_cou.Cno AND tab_score.Sno=tab_stu.Sno";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setCno(rs.getString("tab_score.Cno"));
                score.setCname(rs.getString("Cname"));
                score.setSno(rs.getString("tab_score.Sno"));
                score.setSname(rs.getString("Sname"));
                score.setSclass(rs.getString("Sclass"));
                score.setScore(rs.getInt("Score"));
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return scores;
    }

    @Override
    public List<Score> getAllStuscore() {                  //教师查所教课程、所有学生成绩
        List<Score> scores = new ArrayList<>();
        String sql = "select b.Sno,b.Sname,b.Cno,b.Cname,b.Cterm,b.Credit,b.Tno,b.Tname,b.sclass,Score\n" +
                "FROM\n" +
                "  (select tab_tcou.Cno,tab_tcou.Tno,tab_tcou.Sclass,Site,Tname,Cname,Cterm,Credit,Sno,Sname\n" +
                "      FROM tab_tcou,tab_tea,tab_cou,tab_stu\n" +
                "      WHERE tab_tcou.Cno=tab_cou.Cno\n" +
                "            AND tab_tcou.Tno=tab_tea.Tno AND tab_tcou.Sclass=tab_stu.Sclass)as b\n" +
                "LEFT OUTER join tab_score On b.Sno=tab_score.Sno;";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setSno(rs.getString("Sno"));      //学号、姓名
                score.setSname(rs.getString("Sname"));
                score.setCno(rs.getString("Cno"));          //课程号、课程名、学期、学分
                score.setCname(rs.getString("Cname"));
                score.setCterm(rs.getString("Cterm"));
                score.setCredit(rs.getInt("Credit"));
                score.setTno(rs.getString("Tno"));            //教工号、教师姓名
                score.setTname(rs.getString("Tname"));
                score.setSclass(rs.getString("Sclass"));              //所在班级
                score.setScore(rs.getInt("Score"));                      //得分
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return scores;

    }

    @Override
    public List<Score> stuAllCouscore(String sno) {
        List<Score> scores = new ArrayList<>();
        String sql = "select Cno,Cname,Cterm,Credit,Score from TAB_COU,TAB_SCORE where TAB_SCORE.Cno=TAB_COU.Cno and TAB_SCORE.Sno=?";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ps.setString(1,sno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setCno(rs.getString("Cno"));          //课程号、课程名、学期、学分
                score.setCname(rs.getString("Cname"));
                score.setCterm(rs.getString("Cterm"));
                score.setCredit(rs.getInt("Credit"));
                score.setScore(rs.getInt("Score"));                      //得分
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(ps);
            DBConn.close(conn);
        }
        return scores;

    }

    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public boolean update(Score score) {
        return false;
    }
}
