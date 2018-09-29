package controller;

import com.opensymphony.xwork2.ActionContext;
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
    public String find() {                     //老师自己查找、修改
        tea=imp.findByTno((String)ActionContext.getContext().getSession().get("tno"));
        System.out.print((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }
    public String edit() {              //管理员查找、修改
        tea=imp.findByTno((String)ActionContext.getContext().getSession().get("tno"));
        return SUCCESS;
    }
    public String updatepass() {                 //老师修改密码
        System.out.println("修改教师密码");
        boolean isSuc=imp.updatepass((String)ActionContext.getContext().getSession().get("tno"),
                (String)ActionContext.getContext().getSession().get("tnewpass"));
        return isSuc?SUCCESS:ERROR;
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
