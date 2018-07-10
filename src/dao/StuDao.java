package dao;

import domain.Stu;

import java.util.List;

public interface StuDao {
    boolean check(String sno,String Spass);
    List<Stu> getAllStusByObj();
    Stu findBySno(String sno);           //学生查询自己信息
    boolean updatepass(Stu stu);            //学生修改密码
    Stu findBySclass(String sclass);
    boolean save(Stu stu);
    boolean delBySno(String sno);
    boolean update(Stu stu);
}
