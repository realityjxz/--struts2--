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
    private List<Tcou> tcousByObj;
    private List<Tcou> cnameByTnoByobj;    //查课程——录入成绩

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

    public String execute(){
     tcousByObj=imp.getAllTcousByObj();
    return SUCCESS;
    }

    public String getAllCname(){
        cnameByTnoByobj=imp.getAllCname((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(tcou);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        tcou=imp.findByCno(tcou.getCno());
        return SUCCESS;
    }
    public String findByTno() {
        tcou=imp.findByTno(tcou.getTno());
        return SUCCESS;
    }
    public String findBySclass() {
        tcou=imp.findBySclass(tcou.getSclass());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(tcou);
        return isSuc?SUCCESS:ERROR;
    }
}
