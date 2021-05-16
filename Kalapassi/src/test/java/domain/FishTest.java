
package domain;

import kalapassi.domain.Fish;
import kalapassi.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FishTest {
    
    @Test
    public void sameFishType() {
        Fish f1 = new Fish("Trout");
        Fish f2 = new Fish("Trout");
        assertTrue(f1.equals(f2));
    }
    
    @Test
    public void diffFishType() {
        User u = new User("test", "test");
        Fish f1 = new Fish("Trout");
        Fish f2 = new Fish("Roach");
        assertFalse(f1.equals(f2));
    }
    
    @Test
    public void diffFishDiffFisher() {
        User u1 = new User("test", "test");
        User u2 = new User("abcd", "abcd");
        
        Fish f1 = new Fish("Trout", u1);
        Fish f2 = new Fish("Rainbow trout", u2);
        
        assertFalse(f1.equals(f2));
    }
    
    @Test
    public void diffType() {
        User u = new User("test", "test");
        Fish f = new Fish("Trout", u);
        Object o = new Object();
        assertFalse(f.equals(o));
    }
}
