
package kalapassi.domain;

import java.util.*;


public class User {
    private String name;
    private String username;
    private List<Catch> catchList;
    private int points;
    private int caughtFishAmount;
    
    public User(String name, String username) {
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
    
    public void addCatch() {
        this.caughtFishAmount++;
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
}