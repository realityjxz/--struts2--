package dao;

import java.util.List;
import domain.User;


public interface UserDao {
    boolean check(String username,String password); //登录核对账户密码
    boolean checkregedit(String username);      //注册核对账户名是否存在
    List<String[]> getAllUsers();
    List<User> getAllUsersByObj();
    User findById(long id);
    boolean save(User user);
    boolean delById(long id);
    boolean update(User user);
}