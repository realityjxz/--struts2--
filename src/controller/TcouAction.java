package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import daoimp.TcouDaoImp;
import domain.Tcou;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.List;

public class TcouAction extends ActionSupport {
    private TcouDaoImp imp=new TcouDaoImp();
    private Tcou tcou;
    private List<Tcou> tcousByObj;          //管理员查所有授课信息
    private List<Tcou> cnameByTnoByobj;    //老师查所教课程——录入成绩
    private List<Tcou> allBySnoByobj;    //学生查-课程表-上课地点
    private List<Tcou> allByTnoByobj;    //老师查-课程表-所教课程上课地点


    public Tcou getTcou() {
        return tcou;
    }

    public void setTcou(Tcou tcou) {
        this.tcou = tcou;
    }

    public List<Tcou> getTcousByObj() {
        return tcousByObj;
    }

    public List<Tcou> getCnameByTnoByobj() {
        return cnameByTnoByobj;
    }

    public List<Tcou> getAllBySnoByobj() {
        return allBySnoByobj;
    }

    public List<Tcou> getAllByTnoByobj() {
        return allByTnoByobj;
    }

    public String execute(){
     tcousByObj=imp.getAllTcousByObj();
    return SUCCESS;
    }

    public String getAllCname(){             //老师首页显示所教课程
        cnameByTnoByobj=imp.getAllCname((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(tcou);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        tcou=imp.findByCno(tcou.getCno(),tcou.getTno(),tcou.getSclass());
        return SUCCESS;
    }
    public String findByTno() {                  //老师查授课表
        allByTnoByobj=imp.findByTno((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }
    public String findBySno() {                    //学生查课程表
        allBySnoByobj=imp.findBySno((String)ActionContext.getContext().getSession().get("sno"));
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(tcou);
        return isSuc?SUCCESS:ERROR;
    }
}
