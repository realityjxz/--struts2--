package dao;

import domain.Tea;

import java.util.List;

public interface TeaDao {
    boolean check(String Tno,String Tpass);
    List<Tea> getAllTeasByObj();
    Tea findByTno(String tno);                  //老师自己查询信息
    boolean updatepass(Tea tea);            //老师修改密码
    boolean save(Tea tea);
    boolean delByTno(String tno);
    boolean update(Tea tea);
}
