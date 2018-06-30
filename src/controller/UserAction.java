package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import domain.User;

public class UserAction extends ActionSupport {
    UserDAOImp imp =new UserDAOImp();
    private List<String[]> users;
    private List<User> usersByObj;

    public List<String[]> getUsers() {
        return users;
    }

    public List<User> getUsersByObj() {
        return usersByObj;
    }
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() throws Exception {

        users = imp.getAllUsers();
        getAllUsersByObj();
        return SUCCESS;
    }
    public void getAllUsersByObj()throws Exception {

        usersByObj=imp.getAllUsersByObj();
    }
    public String save() throws Exception{

        boolean isSuc=imp.save(user);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() throws Exception{

        user=imp.findById(user.getId());
        return SUCCESS;
    }
    public String update() throws Exception{

        boolean isSuc=imp.update(user);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() throws Exception{

        boolean isSuc=imp.delById(user.getId());
        return isSuc?SUCCESS:ERROR;
    }
}
