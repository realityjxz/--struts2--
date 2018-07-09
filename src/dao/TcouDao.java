package dao;

import domain.Tcou;

import java.util.List;

public interface TcouDao {
    List<Tcou> getAllTcousByObj();
    List<Tcou> getAllCname(String Tno);
    Tcou findByCno(String cno);
    Tcou findByTno(String tno);
    Tcou findBySclass(String sclass);
    boolean save(Tcou tcou);
    boolean update(Tcou tcou);
}
