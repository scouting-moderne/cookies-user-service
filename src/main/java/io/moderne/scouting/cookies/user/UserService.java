package io.moderne.scouting.cookies.user;

import io.moderne.scouting.cookies.error.ApiError;
import io.moderne.scouting.cookies.error.ApiException;
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

    public User updateUser(String id, User user) {
        if (user.id() != null && !user.id().equals(id)) {
            throw new ApiException(new ApiError("User", "User id cannot be changed", null));
        }
        User old = db.get(id);
        if (old == null) {
            return null;
        }
        db.put(user.id(), user);
        return user;
    }

    public void deleteUser(String id) {
        db.remove(id);
    }
}
