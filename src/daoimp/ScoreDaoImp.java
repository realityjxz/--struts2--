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
    public List<Score> getAllStuscore(String tno) {                  //教师查所教课程、所有班级
        List<Score> scores = new ArrayList<>();
        String sql = "select TAB_TCOU.Cno,Cname,Cterm,Credit,Sclass from TAB_TCOU,TAB_COU where TAB_TCOU.Cno=TAB_COU.Cno and Tno="+tno;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setCno(rs.getString("Cno"));          //课程号、课程名、学期、学分
                score.setCname(rs.getString("Cname"));
                score.setCredit(rs.getInt("Credit"));           //学分
                score.setSclass(rs.getString("Sclass"));           //班级
                score.setCterm(rs.getString("Cterm"));           //学期
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
    public List<Score> logStuscore(String tno) {

        List<Score> scores = new ArrayList<>();
        String sql = "select TAB_TCOU.Cno,Cname,Credit,Sclass,Cterm from TAB_TCOU,TAB_COU where TAB_TCOU.Cno=TAB_COU.Cno and Tno="+tno;
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setCno(rs.getString("Cno"));          //课程号、课程名、学期、学分
                score.setCname(rs.getString("Cname"));
                score.setCterm(rs.getString("Cterm"));
                score.setCredit(rs.getInt("Credit"));
                score.setSclass(rs.getString("Sclass"));              //所在班级
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
    public List<Score> stuAllCouscore(String sno) {                       //学生查自己成绩
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
    public List<Score> sclassAllStuscore(String cno,String sclass) {
        List<Score> scores = new ArrayList<>();
        String sql = "select Sno,Sname,Cno,Cname,Score from TAB_STU,TAB_COU,TAB_SCORE where TAB_STU.Sno=TAB_SCORE.Sno and TAB_SCORE.Cno=TAB_COU.Cno  () ";
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);

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
