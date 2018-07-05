package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.TeaDaoImp;
import domain.Tea;

import java.util.List;

public class TeaAction extends ActionSupport {
    private TeaDaoImp imp=new TeaDaoImp();
    private Tea stu;
    private List<Tea> userByObj;

    public Tea getTea() {
        return stu;
    }

    public void setTea(Tea stu) {
        this.stu = stu;
    }

    public List<Tea> getUserByObj() {
        return userByObj;
    }

    public String execute(){
        userByObj = imp.getAllTeasByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(stu);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        stu=imp.findByTno(stu.getTno());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(stu);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {
        boolean isSuc=imp.delByTno(stu.getTno());
        return isSuc?SUCCESS:ERROR;
    }

}
