
package domain;

import java.util.*;
import kalapassi.dao.FishDao;
import kalapassi.domain.Fish;
import kalapassi.domain.User;

public class FakeFishDao implements FishDao {
    List<Fish> fishes;
    
    public FakeFishDao() {
        fishes = new ArrayList<>();
    }

    public List<Fish> getAll() {
        return fishes;
    }

    @Override
    public Fish create(Fish fish) {
        fishes.add(fish);
        return fish;
    }

    @Override
    public void save() throws Exception {
        
    }

    @Override
    public void getCatchPoints(User loggedUser) throws Exception {
        System.out.println(loggedUser.getPoints());
    }
    
}
