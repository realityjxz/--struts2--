package dao;

import java.util.List;
import domain.User;


public interface UserDAO {
    boolean check(String username,String password) throws Exception;
    List<String[]> getAllUsers() throws Exception;
    List<User> getAllUsersByObj() throws Exception;
    User findById(long id) throws Exception;
    boolean save(User user) throws Exception;
    boolean delById(long id) throws Exception;
    boolean update(User user) throws Exception;
}