package dao;

import domain.Score;

import java.util.List;

public interface ScoreDao {
    List<Score> getAllScoresByObj();
    Score findByScore(String Sno);
    boolean save(Score score);
    boolean update(Score score);
}
