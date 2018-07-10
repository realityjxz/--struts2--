package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import daoimp.ScoreDaoImp;
import domain.Score;
import domain.Tea;

import java.util.List;

public class ScoreAction extends ActionSupport {
    private ScoreDaoImp imp= new ScoreDaoImp();
    private Score score;
    private List<Score> scoresByObj;   //管理员查所有成绩
    private List<Score> stuscoresByObj;   //查学生——录入成绩
    private List<Score> scoreBySno;   //学生查成绩


    Tea tea;

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

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

    public List<Score> getScoreBySno() {
        return scoreBySno;
    }

    public String execute(){
        scoresByObj = imp.getAllScoresByObj();
        return SUCCESS;
    }

    public String stuscore(){                          //学生成绩录入
        stuscoresByObj=imp.getAllStuscore();
        return SUCCESS;
    }

    public String myscore(){                          //学生自己查询
        scoreBySno=imp.stuAllCouscore((String)ActionContext.getContext().getSession().get("sno"));
        return SUCCESS;
    }

}
