package dao;

import domain.Cla;

import java.util.List;

public interface ClaDao {
    List<Cla> getAllClasByObj();
    Cla findBySclass(String sclass);
    boolean save(Cla cla);
    boolean delBySclass(String sclass);
    boolean update(Cla cla);
}
