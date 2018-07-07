package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.TcouDaoImp;
import domain.Tcou;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.List;

public class TcouAction extends ActionSupport {
    private TcouDaoImp imp=new TcouDaoImp();
    private Tcou tcou;
    private List<Tcou> tcousByObj;

    public Tcou getTcou() {
        return tcou;
    }

    public void setTcou(Tcou tcou) {
        this.tcou = tcou;
    }

    public List<Tcou> getTcousByObj() {
        return tcousByObj;
    }
    public String execute(){
     tcousByObj=imp.getAllTcousByObj();
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
