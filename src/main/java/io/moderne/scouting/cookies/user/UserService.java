package io.moderne.scouting.cookies.user;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> db = new HashMap<>();
    public User createUser(User user) {
        db.put(user.id(), user);
        return user;
    }
    public User findUser(String id) {
        return db.get(id);
    }
}
