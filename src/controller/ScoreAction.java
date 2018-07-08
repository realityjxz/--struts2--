package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.ScoreDaoImp;
import domain.Score;

import java.util.List;

public class ScoreAction extends ActionSupport {
    private ScoreDaoImp imp= new ScoreDaoImp();
    private Score score;
    private List<Score> scoresByObj;   //查成绩单
    private List<Score> stuscoresByObj;   //查学生


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public List<Score> getScoresByObj() {
        return scoresByObj;
    }

    public List<Score> getStuscoresByObj() {
        return stuscoresByObj;
    }


    public String execute(){
        scoresByObj = imp.getAllScoresByObj();
        return SUCCESS;
    }

    public String stuscore(){

        stuscoresByObj=imp.getAllStuscore();
        return SUCCESS;
    }
}