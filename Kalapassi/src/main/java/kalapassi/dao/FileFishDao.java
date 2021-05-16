package kalapassi.dao;

import java.io.*;
import java.util.*;
import kalapassi.domain.Fish;
import kalapassi.domain.User;

public class FileFishDao implements FishDao {

    public List<Fish> catches;
    private final String file;

    public FileFishDao(String file, UserDao users) throws Exception {
        catches = new ArrayList<>();
        this.file = file;

        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User user = users.getAll()
                        .stream()
                        .filter(u
                                -> u.getUsername().equals(parts[0])
                        )
                        .findFirst()
                        .orElse(null);

                Fish caught = new Fish(Integer.parseInt(parts[1]), user);
                catches.add(caught);
            }
        } catch (Exception e) {
            System.out.println("Error whilst reading 'fishes.txt': " + e.getMessage());
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public Fish create(Fish fish) throws Exception {
        catches.add(fish);
        save();
        return fish;
    }

    @Override
    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Fish fish : catches) {
                writer.write(fish.getUsername() + ";" + fish.getPoints() + "\n");
            }
        }
    }

    @Override
    public void getCatchPoints(User loggedUser) {
        int returnPoints = 0;
        int amountOfFish = 0;

        for (Fish f : catches) {
            if (f.getUsername().equals(loggedUser.getUsername())) {
                returnPoints += f.getPoints();
                amountOfFish++;
            }
        }

        loggedUser.setPoints(returnPoints);
        loggedUser.setCaughtFishAmount(amountOfFish);

    }
}
