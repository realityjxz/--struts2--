package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import daoimp.StuDaoImp;
import domain.Stu;

import java.util.List;

public class StuAction extends ActionSupport {
    private StuDaoImp imp=new StuDaoImp();
    private Stu stu;
    private List<Stu> stusByObj;

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public List<Stu> getStusByObj() {
        return stusByObj;
    }


    public String execute(){
        stusByObj = imp.getAllStusByObj();
        return SUCCESS;
    }
    public String save(){
        boolean isSuc=imp.save(stu);
        return isSuc?SUCCESS:ERROR;
    }
    public String find() {                     //学生自己查看个人信息
        stu=imp.findBySno((String)ActionContext.getContext().getSession().get("sno"));
        System.out.print((String)ActionContext.getContext().getSession().get("sno"));
        return SUCCESS;
    }

    public String updatepass() {                 //学生修改密码
        System.out.print("修改");
        boolean isHave = imp.check(stu.getSno(), stu.getSpass());
        if (isHave) {
            boolean isSuc = imp.updatepass(stu);
            if(isSuc){
                return SUCCESS;
            }else{
                addActionError(getText("update.fail"));
                return ERROR;
            }

        } else {
            addActionError(getText("login.fail"));
            return ERROR;
        }
    }
    public String edit() {                                           //学生修改密码
        System.out.print("111");
        stu=imp.findBySno((String)ActionContext.getContext().getSession().get("sno"));
        System.out.println((String)ActionContext.getContext().getSession().get("sno"));
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
