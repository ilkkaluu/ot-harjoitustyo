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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCatch(String fish) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
