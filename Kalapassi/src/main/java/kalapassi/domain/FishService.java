package kalapassi.domain;

import java.util.*;
import kalapassi.dao.*;

public class FishService {

    private FishDao fishDao;
    private UserDao userDao;
    private User loggedIn;
    private Fish catchFish;

    public FishService(FishDao fishDao, UserDao userDao) {
        this.userDao = userDao;
        this.fishDao = fishDao;
    }

    public List<Fish> getCatches() {
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

    public boolean addCatch(String fish) {
        int points = -1;
        
        Fish c = new Fish(fish, points, loggedIn);

            try {
                //catchDao.save();
                fishDao.create(c);
            } catch (Exception e) {
                return false;
            }
            return true;
        //}
        //return false;
    }
}
