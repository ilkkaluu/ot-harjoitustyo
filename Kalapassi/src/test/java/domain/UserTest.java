
package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kalapassi.domain.User;

public class UserTest {
    
    @Test
    public void sameUsername() {
        User u1 = new User("Test", "test");
        User u2 = new User("Test", "test");
        assertTrue(u1.equals(u2));
    }
    
    @Test
    public void diffUsername() {
        User u1 = new User("Test", "test");
        User u2 = new User("Testaaja", "testaaja");
        assertFalse(u1.equals(u2));
    }
    
    @Test
    public void diffType() {
        User u = new User("Test", "test");
        Object o = new Object();
        assertFalse(u.equals(o));
    }
    
    @Test
    public void catchCountMatches() {
        User u = new User("test", "test");
        u.setCaughtFishAmount(5);
        assertTrue(u.getCaughtFishAmount() == 5);
    }
    
    @Test
    public void catchCountDoesntMatch() {
        User u = new User("test", "test");
        u.setCaughtFishAmount(5);
        assertFalse(u.getCaughtFishAmount() == 1);
    }
    
    @Test
    public void addCatchIncreasesCatchCount() {
        User u = new User("test", "test");
        u.addCatch("Trout");
        assertTrue(u.getCaughtFishAmount() == 1);
    }
}
