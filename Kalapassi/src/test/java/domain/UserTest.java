
package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kalapassi.domain.User;

public class UserTest {
    
    @Test
    public void equalWhenSameUsername() {
        User u1 = new User("Test", "test");
        User u2 = new User("Test", "test");
        assertTrue(u1.equals(u2));
    }
    
    @Test
    public void nonEqualWhenDifferentUsername() {
        User u1 = new User("Test", "test");
        User u2 = new User("Testaaja", "testaaja");
        assertFalse(u1.equals(u2));
    }
    
    @Test
    public void nonEqualWhenDifferentType() {
        User u = new User("Test", "test");
        Object o = new Object();
        assertFalse(u.equals(o));
    }
}
