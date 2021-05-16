package kalapassi.domain;

import java.util.*;

public class Fish {

    private int id;
    private String fish;
    private int points;
    private User user;
    private List<Fish> catchList;

    public Fish(String fish, int points, User user) {
        this.id = id;
        this.fish = fish;
        switch (fish) {
            case "Grayling":
                this.points = 30;
                break;
            case "Perch":
                this.points = 5;
                break;
            case "Rainbow trout":
                this.points = 20;
                break;
            case "Roach":
                this.points = 1;
                break;
            case "Trout":
                this.points = 25;
                break;
            default:
                break;
        }
        this.user = user;
        this.catchList = new ArrayList<>();
    }

    public Fish(String fish) {
        this.fish = fish;
        switch (fish) {
            case "Grayling":
                this.points = 30;
                break;
            case "Perch":
                this.points = 5;
                break;
            case "Rainbow trout":
                this.points = 20;
                break;
            case "Roach":
                this.points = 1;
                break;
            case "Trout":
                this.points = 25;
                break;
            default:
                break;
        }
    }

    public void setInt(int id) {
        this.id = id;
    }

    public String getFishType() {
        return this.fish;
    }
    
    public int getPoints() {
        return this.points;
    }

    public List<Fish> getCatches() {
        return this.catchList;
    }


    public String getUsername() {
        return this.user.getUsername();
    }

    public int getId() {
        return this.id;
    }

    public boolean addCatch(Fish c) {
        return this.catchList.add(c);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fish)) {
            return false;
        }
        Fish other = (Fish) obj;
        return user.equals(other.user);
    }
}
