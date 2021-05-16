package dao;

import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.TemporaryFolder;
import kalapassi.dao.UserDao;
import kalapassi.domain.User;
import kalapassi.dao.FileUserDao;

public class FileUserDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    File userFile;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userFile = tempFolder.newFile("testfile_users.txt");

        try (FileWriter writer = new FileWriter(userFile.getAbsolutePath())) {
            writer.write("test;user\n");
        }
        userDao = new FileUserDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void fileReadWorks() {
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
        User u = users.get(0);
        assertEquals("test", u.getUsername());
        assertEquals("user", u.getName());
    }
    
    @Test
    public void findUserWorks() {
        User u = userDao.findByUsername("test");
        assertEquals("test", u.getUsername());
        assertEquals("user", u.getName());
    }
    
    @Test
    public void userCannotBeFound() {
        User u = userDao.findByUsername("minni");
        assertEquals(null, u);
    }
    
    @Test
    public void addedUserIsFound() throws Exception {
        User u = new User("minni", "hiiri");
        userDao.create(u);
        
        User user = userDao.findByUsername("minni");
        assertEquals("minni", user.getUsername());
        assertEquals("hiiri", user.getName());
    }
    
    @After
    public void deleteTestFile() {
        userFile.delete();
    }
}
