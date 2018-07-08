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
    public List<Score> getAllStuscore() {              //查所有学生所学课程成绩
        List<Score> scores = new ArrayList<>();
        String sql = "select tab_tcou.Cno,tab_tcou.sclass,tab_tcou_Tno,tab_stu_Sno,Score,Sname,Cname,Tname FROM tab_tcou,tab_cou,tab_stu,tab_tea,tab_score WHERE ";
        System.out.print("2222");
        Connection conn = DBConn.getConnection();
        PreparedStatement ps = DBConn.prepare(conn,sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// 保存每行的数据
                Score score = new Score();
                score.setCno(rs.getString("tab_cou.Cno"));
                score.setCname(rs.getString("Cname"));
                score.setSno(rs.getString("tab_stu.Sno"));
                score.setSname(rs.getString("Sname"));
                score.setSclass(rs.getString("Sclass"));
                score.setScore(rs.getInt("Score"));
                System.out.print("44");
                System.out.print(rs.getString("tab_stu.Sno"));
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
    public Score findByScore(String Sno) {

        return null;
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
