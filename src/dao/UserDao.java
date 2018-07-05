package dao;

import java.util.List;
import domain.User;


public interface UserDao {
    boolean check(String username,String password);
    List<String[]> getAllUsers();
    List<User> getAllUsersByObj();
    User findById(long id);
    boolean save(User user);
    boolean delById(long id);
    boolean update(User user);
}