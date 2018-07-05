package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daoimp.TeaDaoImp;
import daoimp.UserDaoImp;
import daoimp.StuDaoImp;
import domain.*;

public class CheckLogin extends ActionSupport {

    private User user;
    private Stu stu;
    private Tea tea;

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void validateCheckuser() {
        if (user.getUsername().isEmpty()) {
            addFieldError("user.username", getText("username.empty"));
        }
        if (user.getPass().isEmpty()) {
            addFieldError("user.pass", getText("pass.empty"));
        }
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String checkuser(){
        UserDaoImp imp = new UserDaoImp();
        boolean isHave = imp.check(user.getUsername(),user.getPass());     //调用实现类中check方法
        if (isHave) {
            Map session = ActionContext.getContext().getSession();
            session.put("username", user.getUsername());
            List args = new ArrayList();
            args.add(user.getUsername());
            args.add(user.getPass());
            System.out.println(getText("user.info", args));
            return "success";    //forward,redirect
        } else {
            addActionError(getText("login.fail"));
            return "fail";
        }

    }

    public void validateCheckStu() {
        if(stu.getSno().isEmpty()){
            addFieldError("stu.Sno",getText("Sno.empty"));
        }
        if(stu.getSpass().isEmpty()){
            addFieldError("stu.Spass",getText("pass.empty"));
        }
    }
    public String checkStu(){
        StuDaoImp simp = new StuDaoImp();
        boolean isHave=simp.check(stu.getSno(),stu.getSpass());
        if(isHave){
            Map session=ActionContext.getContext().getSession();
            session.put("username", stu.getSname());
            return "suc";//自定义指向的页面
        }else
            return "fail";
    }


    public void validateCheckTea(){
        if(tea.getTno().isEmpty()){
            addFieldError("tea.Tno",getText("Tno.empty"));
        }
        if(tea.getTpass().isEmpty()){
            addFieldError("tea.Tpass",getText("pass.empty"));
        }

    }
    public String checkTea(){
        TeaDaoImp timp=new TeaDaoImp();
        boolean isHave=timp.check(tea.getTno(),tea.getTpass());
        if(isHave){
            Map session=ActionContext.getContext().getSession();
            session.put("username", tea.getTname());
            return "suc";//自定义指向的页面
        }else
            return "fail";
    }

}

