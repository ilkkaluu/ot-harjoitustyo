package domain;

import java.util.*;
import kalapassi.dao.UserDao;
import kalapassi.domain.User;

public class FakeUserDao implements UserDao {
    List<User> users = new ArrayList<>();
    
    public FakeUserDao() {
        users.add(new User("test", "user"));
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream().filter(u->u.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCatch(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
