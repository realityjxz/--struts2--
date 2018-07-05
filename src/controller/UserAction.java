package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import daoimp.UserDaoImp;
import domain.User;

public class UserAction extends ActionSupport {
    private UserDaoImp imp =new UserDaoImp();
    private List<String[]> users;
    private List<User> usersByObj;

    public List<String[]> getUsers() {
        return users;
    }

    public List<User> getUsersByObj() {
        return usersByObj;
    }
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){

        users = imp.getAllUsers();
        getAllUsersByObj();
        return SUCCESS;
    }
    public void getAllUsersByObj(){

        usersByObj=imp.getAllUsersByObj();
    }
    public String save(){

        boolean isSuc=imp.save(user);
        return isSuc?SUCCESS:ERROR;
    }
    public String edit() {

        user=imp.findById(user.getId());
        return SUCCESS;
    }
    public String update(){

        boolean isSuc=imp.update(user);
        return isSuc?SUCCESS:ERROR;
    }
    public String del() {

        boolean isSuc=imp.delById(user.getId());
        return isSuc?SUCCESS:ERROR;
    }
}
