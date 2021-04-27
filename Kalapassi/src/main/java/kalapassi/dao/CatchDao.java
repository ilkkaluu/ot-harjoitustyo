package kalapassi.dao;

import java.util.*;
import kalapassi.domain.Catch;

public interface CatchDao {

    List<Catch> getAll();

    boolean addCatch(String fish);

    void save() throws Exception;
}
