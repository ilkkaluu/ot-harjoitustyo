package kalapassi.dao;

import java.util.*;
import kalapassi.domain.Fish;

public interface FishDao {

    List<Fish> getAll();

    boolean addCatch(String fish);

    void save() throws Exception;
}
