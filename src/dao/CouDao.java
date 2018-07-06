package dao;

import domain.Cou;

import java.util.List;

public interface CouDao {
    List<Cou> getAllCousByObj();
    Cou findByCno(String sno);
    boolean save(Cou cou);
    boolean delByCno(String cno);
    boolean update(Cou cou);
}
