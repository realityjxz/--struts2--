package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.CouDaoImp;
import domain.Cou;

import java.util.List;

public class CouAction extends ActionSupport{
    private CouDaoImp imp=new CouDaoImp();
    private Cou cou;
    private List<Cou> cousByObj;

    public Cou getCou() {
        return cou;
    }

    public void setCou(Cou cou) {
        this.cou = cou;
    }

    public List<Cou> getCousByObj() {
        return cousByObj;
    }

    public String execute(){
        cousByObj = imp.getAllCousByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(cou);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        cou=imp.findByCno(cou.getCno());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(cou);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {
        boolean isSuc=imp.delByCno(cou.getCno());
        return isSuc?SUCCESS:ERROR;
    }
}
