package com.example.FrontControllerEx.domain.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    private static final UserRepository instance = new UserRepository();

    public static UserRepository getInstance(){
        return instance;
    }

    public UserRepository() {
    }

    public User save(User user) {
        user.setSystemid(++sequence);
        store.put(user.getSystemid(), user);
        return user;
    }

    public User findBySystemId(Long id) {
        return store.get(id);
    }

    public List<User> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
