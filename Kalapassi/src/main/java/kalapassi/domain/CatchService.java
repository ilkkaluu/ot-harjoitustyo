package kalapassi.domain;

import java.util.*;
import kalapassi.dao.*;

public class CatchService {

    private CatchDao catchDao;
    private UserDao userDao;
    private User loggedIn;
    private Catch catchFish;

    public CatchService(CatchDao catchDao, UserDao userDao) {
        this.userDao = userDao;
        this.catchDao = catchDao;
    }

    public List<Catch> getCatches() {
        if (loggedIn == null) {
            return new ArrayList<>();
        }

        return loggedIn.getCatches();
    }

    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    public User getLoggedUser() {
        return loggedIn;
    }

    public String getUsername() {
        return this.loggedIn.getUsername();
    }

    public int getPoints() {
        return this.loggedIn.getPoints();
    }

    public void logOut() {
        loggedIn = null;
    }

    public boolean createUser(String username, String name) {
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, name);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean addCatch(String fish, int points) {
        Catch c = new Catch(fish, points);

        if (loggedIn.addCatch(c)) {
            try {
                catchDao.save();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
}
