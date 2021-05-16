package kalapassi.domain;
 
import kalapassi.dao.*;
 
public class FishService {
    private final FishDao fishDao;
    private final UserDao userDao;
    private User loggedIn;
 
    public FishService(FishDao fishDao, UserDao userDao) {
        this.userDao = userDao;
        this.fishDao = fishDao;
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
        Fish c = new Fish(fish, loggedIn);
 
        try {
            fishDao.create(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
 
        loggedIn.setPoints(loggedIn.getPoints() + c.getPoints());
        return true;
    }
 
    public int calculateCatchPoints() {
        try {
            fishDao.getCatchPoints(loggedIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
        return loggedIn.getPoints();
    }
}