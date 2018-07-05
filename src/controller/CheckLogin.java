package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daoimp.UserDAOImp;
import domain.*;

public class CheckLogin extends ActionSupport {

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void validate() {
        if (user.getUsername().isEmpty()) {
            addFieldError("user.username", getText("username.empty"));
        }
        if (user.getPass().isEmpty()) {
            addFieldError("user.pass", getText("pass.empty"));
        }
    }

    @Override
    public String execute() throws Exception {
        UserDAOImp imp = new UserDAOImp();
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
//    public String checkStu()throws Exception{
//        StuDAO dao=new StuDAOImp();
//        boolean isHave=dao.check(username);
//        if(isHave){
//            Map session=ActionContext.getContext().getSession();
//            session.put("username", username);
//            return "suc";//自定义指向的页面
//        }else
//            return "fail";
//    }
//    public String checkTea()throws Exception{
//        StuDAO dao=new StuDAOImp();
//        boolean isHave=dao.check(username);
//        if(isHave){
//            Map session=ActionContext.getContext().getSession();
//            session.put("username", username);
//            return "suc";//自定义指向的页面
//        }else
//            return "fail";
//    }

}

