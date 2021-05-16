
package domain;

import kalapassi.domain.FishService;
import kalapassi.domain.User;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;

public class FishServiceUserTest {
    FakeFishDao fishDao;
    FakeUserDao  userDao;
    FishService service;
    
    @Before
    public void setUp() {
        userDao = new FakeUserDao();
        fishDao = new FakeFishDao();
        service = new FishService(fishDao, userDao);
    }
    
    @Test
    public void noRegisterNoLogin() {
        boolean result = service.login("isNotFound");
        assertFalse(result);
        
        assertEquals(null, service.getLoggedUser());
    }
    
    @Test
    public void registeredCanLogIn() {
        boolean result = service.login("test");
        assertTrue(result);
        
        User loggedIn = service.getLoggedUser();
        assertEquals("user", loggedIn.getName());
    }
    
    @Test
    public void loggedInLogOut() {
        service.login("test");
        service.logOut();
        
        assertEquals(null, service.getLoggedUser());
    }
    
    @Test
    public void usernameNotUnique() {
        boolean result = service.createUser("test", "user");
        assertFalse(result);
    }
    
    @Test
    public void createdUserCanLogIn() {
        boolean result = service.createUser("user", "user");
        assertTrue(result);
        
        boolean login = service.login("user");
        assertTrue(login);
        
        User loggedIn = service.getLoggedUser();
        assertEquals("user", loggedIn.getUsername());
    }
}
