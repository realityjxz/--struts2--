package controller;

import com.opensymphony.xwork2.ActionSupport;
import daoimp.StuDaoImp;
import domain.Stu;

import java.util.List;

public class StuAction extends ActionSupport {
    private StuDaoImp imp=new StuDaoImp();
    private Stu stu;
    private List<Stu> userByObj;

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public List<Stu> getUserByObj() {
        return userByObj;
    }


    public String execute(){
        userByObj = imp.getAllStusByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(stu);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {
        stu=imp.findBySno(stu.getSno());
        return SUCCESS;
    }
    public String update(){
        boolean isSuc=imp.update(stu);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {
        boolean isSuc=imp.delBySno(stu.getSno());
        return isSuc?SUCCESS:ERROR;
    }

}
