package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

import dao.*;
import domain.User;

public class Regedit extends ActionSupport {
    String repass;
    /*Date birth;*/
    User user;


    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    /*public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }*/
    public Date getMinDate(){
        return new GregorianCalendar(1900,0,1).getTime();
    }
    public Date getMaxDate() {
        return new GregorianCalendar(2020, 0, 1).getTime();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public  String execute() throws Exception{
        Map session = ActionContext.getContext().getSession();
        session.put("username", user.getUsername());
        UserDAOImp imp = new UserDAOImp();
        boolean isSuc = imp.save(user);    //调用实现类中save方法
        return isSuc?SUCCESS:ERROR;
    }
}

