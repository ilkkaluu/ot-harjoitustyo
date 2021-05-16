package kalapassi.dao;

import kalapassi.domain.Fish;
import kalapassi.domain.User;

public interface FishDao {

    Fish create(Fish fish) throws Exception;

    void save() throws Exception;

    void getCatchPoints(User loggedUser) throws Exception;
}
