package dao;

import domain.Stu;

import java.util.List;

public interface StuDao {
    boolean check(String username,String password);
    List<Stu> getAllStusByObj();
    Stu findBySno(String sno);
    boolean save(Stu stu);
    boolean delBySno(String sno);
    boolean update(Stu stu);
}
