package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.TeaDaoImp;
import domain.Tea;

import java.util.List;

public class TeaAction extends ActionSupport {
    private TeaDaoImp imp=new TeaDaoImp();
    private Tea tea;
    private List<Tea> teasByObj;

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea stu) {
        this.tea = stu;
    }

    public List<Tea> getTeasByObj() {
        return teasByObj;
    }

    public String execute(){
        teasByObj = imp.getAllTeasByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(tea);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        tea=imp.findByTno(tea.getTno());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(tea);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {
        boolean isSuc=imp.delByTno(tea.getTno());
        return isSuc?SUCCESS:ERROR;
    }

}
