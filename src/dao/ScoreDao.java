package dao;

import domain.Score;

import java.util.List;

public interface ScoreDao {
    List<Score> getAllScoresByObj();          //管理员查
    List<Score> getAllStuscore();              //老师查自己所教课程-学生成绩
    List<Score> stuAllCouscore(String sno);              //学生查自己所有课程成绩
    boolean save(Score score);
    boolean update(Score score);
}
