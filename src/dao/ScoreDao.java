package dao;

import domain.Score;

import java.util.List;

public interface ScoreDao {
    List<Score> getAllScoresByObj();          //管理员查成绩表
    List<Score> getAllStuscore(String tno);              //老师查自己所教课程学生成绩
    List<Score> logStuscore(String tno);              //老师查自己所教课程-录入学生成绩
    List<Score> stuAllCouscore(String sno);              //学生查自己所有课程成绩
    List<Score> sclassAllStuscore(String cno,String sclass);              //一个班级该门课所有学生成绩
    boolean save(Score score);
    boolean update(Score score);
}
