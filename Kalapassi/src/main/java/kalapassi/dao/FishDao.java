package kalapassi.dao;

import java.util.*;
import kalapassi.domain.Fish;

public interface FishDao {

    List<Fish> getAll();

    Fish create(Fish fish) throws Exception;

    void save() throws Exception;
}
