package kalapassi.dao;

import java.io.*;
import java.util.*;
import kalapassi.domain.Fish;
import kalapassi.domain.User;

public class FileFishDao implements FishDao {

    public List<Fish> catches;
    private String catchFile;
    private Scanner reader;
    private Fish latest;
    private String file;
    private User user;

    public FileFishDao(String file, UserDao users) throws Exception {
        catches = new ArrayList<>();
        this.file = file;

        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User user = users.getAll().stream().filter(u -> u.getUsername().equals(parts[2])).findFirst().orElse(null);
                Fish caught = new Fish(parts[0], Integer.parseInt(parts[1]), user);
                catches.add(caught);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public List<Fish> getAll() {
        return latest.getCatches();
    }

    @Override
    public Fish create(Fish fish) throws Exception {
        /*String[] fishInfo = line.split(";");
        String fishType = fishInfo[0];
        String points = fishInfo[1];
        latest = new Fish(fish);
        return catches.add(latest);*/
        
        catches.add(fish);
        save();
        return fish;
        
    }

    @Override
    public void save() throws Exception {
        /*try (FileWriter writer = new FileWriter(new File(file))) {
            for (Fish f : catches) {
                writer.write(f.getUsername() + "\n");
                writer.write("Catches & points: ");
                writer.write("\n");
                if (!f.getCatches().isEmpty()) {
                    for (Fish fi : f.getCatches()) {
                        writer.write(fi.getFishType() + ";" + fi.getPoints() + "\n");
                    }
                }
                writer.write("\n");
            }
        }*/
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Fish fish : catches) {
                writer.write(fish.getUsername() + "; " + fish.getPoints() + "\n");
            }
        }
    }

}
