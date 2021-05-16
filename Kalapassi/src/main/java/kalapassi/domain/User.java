
package kalapassi.domain;

import java.util.*;


public class User {
    private String name;
    private String username;
    private List<Fish> catchList;
    private int points;
    private int caughtFishAmount;
    
    public User(String username, String name) {
        this.name = name;
        this.username = username;
        this.catchList = new ArrayList<>();
        this.points = 0;
        this.caughtFishAmount = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public boolean addCatch(String fishType) {
        Fish f = new Fish(fishType);
        return this.catchList.add(f);
    }
    
    public int getCaughtFishAmount() {
        return this.caughtFishAmount;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        
        User other = (User) obj;
        return username.equals(other.username);
    }

    List<Fish> getCatches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean addCatch(Fish c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
