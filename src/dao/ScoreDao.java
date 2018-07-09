package dao;

import domain.Score;

import java.util.List;

public interface ScoreDao {
    List<Score> getAllScoresByObj();
    List<Score> getAllStuscore();
    boolean save(Score score);
    boolean update(Score score);
}
