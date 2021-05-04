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
        this.points = 0;
        this.user = user;
        this.catchList = new ArrayList<>();
    }

    public Fish(String fish, int points) {
        this.fish = fish;
        this.points = 0;
    }

    public void setInt(int id) {
        this.id = id;
    }

    public String getCatch() {
        return this.fish;
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
