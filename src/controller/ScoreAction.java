package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import daoimp.ScoreDaoImp;
import domain.Score;
import domain.Tea;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ScoreAction extends ActionSupport {
    private ScoreDaoImp imp= new ScoreDaoImp();
    private Score score;
    private List<Score> scoresByObj;   //管理员查所有成绩
    private List<Score> stuscoresByObj;   //查学生——录入成绩
    //教师查所教课程、所有班级
    private List<Score> scoreByTno;   //查学生——录入成绩
    private List<Score> scoreByClass;   //通过班级查成绩
    private List<Score> scoreBySno;   //学生查成绩


    Tea tea;

    public List<Score> getScoreByClass() {
        return scoreByClass;
    }

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

    public List<Score> getScoreByTno() {
        return scoreByTno;
    }

    public String execute(){
        scoresByObj = imp.getAllScoresByObj();
        return SUCCESS;
    }

    public String stuscore(){                          //老师通过工号Tno查询---学生成绩录入
        stuscoresByObj=imp.getAllStuscore((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }

    public String myscore(){                        //学生自己查询
        scoreBySno=imp.stuAllCouscore((String)ActionContext.getContext().getSession().get("sno"));
        return SUCCESS;
    }
    public String queryscore(){                          //教师查所教课程、所有班级
        scoreByTno=imp.getAllStuscore((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }

    public String queryscoreByClass(){
        ActionContext context=ActionContext.getContext();
        Map params=context.getParameters();
        System.out.println(params);
        System.out.println(params.get("Cno"));
        System.out.println(params.get("Sclass"));
        String Cno=String.valueOf(params.get("Cno"));
        String Sclass=String.valueOf(params.get("Sclass"));
        scoreByClass=imp.sclassAllStuscore(Cno,Sclass);
        return SUCCESS;
    }


}
