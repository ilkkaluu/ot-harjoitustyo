package kalapassi.dao;

import java.util.*;
import kalapassi.domain.User;

public interface UserDao {

    User create(User user) throws Exception;

    User findByUsername(String username);

    List<User> getAll();

    void save() throws Exception;

    void addCatch(String line);

    boolean addUser(String line);
}
