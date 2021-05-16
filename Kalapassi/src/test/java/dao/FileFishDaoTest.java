package dao;

import domain.FakeUserDao;
import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.TemporaryFolder;
import kalapassi.domain.User;
import kalapassi.dao.FishDao;
import kalapassi.dao.UserDao;
import kalapassi.domain.Fish;
import kalapassi.dao.FileFishDao;

public class FileFishDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    File fishFile;
    FishDao fishDao;

    @Before
    public void setUp() throws Exception {
        fishFile = tempFolder.newFile("testfile_users.txt");
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("test", "user"));

        try (FileWriter writer = new FileWriter(fishFile.getAbsolutePath())) {
            writer.write("user;20");
        }
        fishDao = new FileFishDao(fishFile.getAbsolutePath(), userDao);
    }
    
    @After
    public void deleteFile() {
       fishFile.delete();
    }
}
