package kalapassi.dao;

import java.util.*;
import java.io.*;
import kalapassi.domain.User;

public class FileUserDao implements UserDao {

    private List<User> users;
    private String file;
    private User latest;
    private Scanner reader;

    public FileUserDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;

        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], parts[1]);
                users.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();

        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User u : users) {
                writer.write(u.getName() + ";" + u.getUsername() + "\n");
            }
        }
    }

    @Override
    public void addCatch(String line) {
        if (reader.hasNextLine()) {
            line = reader.nextLine();
            while (!line.equals("")) {
                String[] catchLine = line.split(";");
                String catchType = catchLine[0];
                String catchPoints = catchLine[1];
                latest.addCatch(catchType, Integer.parseInt(catchPoints));

                if (reader.hasNext()) {
                    line = reader.nextLine();
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public boolean addUser(String line) {
        line = reader.nextLine();
        String[] parts = line.split(";");
        User u = new User(parts[0], parts[1]);
        latest = u;
        return users.add(u);
    }

}
