package dao;

import domain.Tea;

import java.util.List;

public interface TeaDao {
    boolean check(String Tno,String Tpass);
    List<Tea> getAllTeasByObj();
    Tea findByTno(String tno);
    boolean save(Tea tea);
    boolean delByTno(String tno);
    boolean update(Tea tea);
}
