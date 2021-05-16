package kalapassi.domain;
 
import java.util.*;
 
public class User {
    private final String name;
    private final String username;
    private final List<Fish> catchList;
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
 
    public void setPoints(int points) {
        this.points = points;
    }
 
    public int getPoints() {
        return this.points;
    }
 
    public boolean addCatch(String fishType) {
        Fish f = new Fish(fishType);
        this.caughtFishAmount++;
        return this.catchList.add(f);
    }
 
    public int getCaughtFishAmount() {
        return this.caughtFishAmount;
    }
 
    public void setCaughtFishAmount(int amount) {
        this.caughtFishAmount = amount;
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
        return this.catchList;
    }
}