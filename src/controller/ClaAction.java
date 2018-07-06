package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.ClaDaoImp;
import domain.Cla;

import java.util.List;

public class ClaAction extends ActionSupport {
    private ClaDaoImp imp=new ClaDaoImp();
    private Cla cla;
    private List<Cla> clasByObj;

    public Cla getCla() {
        return cla;
    }

    public void setCla(Cla cla) {
        this.cla = cla;
    }

    public List<Cla> getClasByObj() {
        return clasByObj;
    }

    public String execute(){
        clasByObj = imp.getAllClasByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(cla);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        cla=imp.findBySclass(cla.getSclass());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(cla);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {
        boolean isSuc=imp.delBySclass(cla.getSclass());
        return isSuc?SUCCESS:ERROR;
    }
}
