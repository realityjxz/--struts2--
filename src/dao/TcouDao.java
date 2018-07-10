package dao;

import domain.Tcou;

import java.util.List;

public interface TcouDao {
    List<Tcou> getAllTcousByObj();            //管理员查看所有
    List<Tcou> getAllCname(String tno);            //老师查看自己所教-课程名-首页显示
    Tcou findByCno(String cno,String tno,String sclass);           //管理员查某门课程
    List<Tcou> findByTno(String tno);             //老师查授课表
    List<Tcou> findBySno(String sno);                 //学生查课程表
    boolean save(Tcou tcou);
    boolean update(Tcou tcou);
}
